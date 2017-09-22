package bugs.reproduce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.objectbox.BoxStore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // teacher1 has an empty student list after this. debugging into the constructor shows that
        // the student does get set into the relation but after the constructor finishes the ToMany
        // field is empty again
        val teacher1 = TeacherWithLessons(listOf(Student()))

        // teacher2 gets the student set after the constructor is finished, all works as expected
        val teacher2 = TeacherWithLessons(listOf())
        teacher2.students.add(Student())

        // teacher3 to teacher6 also work as expected, so it seems the problem is that
        // TeacherWithLessons has another list field that is initialized with the default value
        // defined in the constructor
        val teacher3 = Teacher(listOf(Student()))
        val teacher4 = Teacher(listOf())
        teacher4.students.add(Student())
        val teacher5 = TeacherWithLessons(listOf(Student()), listOf(Lesson()))
        val teacher6 = TeacherWithLessons(listOf(Student()), listOf())

        if (teacher6.students.isEmpty()) {
            throw IllegalStateException("Teacher 6 has no student set")
        }

        if (teacher5.students.isEmpty()) {
            throw IllegalStateException("Teacher 5 has no student set")
        }

        if (teacher4.students.isEmpty()) {
            throw IllegalStateException("Teacher 4 has no student set")
        }

        if (teacher3.students.isEmpty()) {
            throw IllegalStateException("Teacher 3 has no student set")
        }


        if (teacher2.students.isEmpty()) {
            throw IllegalStateException("Teacher 2 has no student set")
        }

        if (teacher1.students.isEmpty()) {
            throw IllegalStateException("Teacher 1 has no student set")
        }
    }
}
