package bugs.reproduce

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
class TeacherWithLessons(@Transient private val studentsForInit: List<Student>, val lessons: List<Lesson> = listOf()) {

    @Id
    var id: Long = 0

    lateinit var students: ToMany<Student>

    init {
        students.addAll(studentsForInit)
    }

}