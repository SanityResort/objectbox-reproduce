package bugs.reproduce

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
class Teacher (@Transient private val studentsForInit: List<Student>) {
    @Id
    var id: Long = 0
    lateinit var students: ToMany<Student>

    init {
        students.addAll(studentsForInit)
    }
}