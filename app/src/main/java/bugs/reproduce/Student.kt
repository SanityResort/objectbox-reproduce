package bugs.reproduce

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Student {

    @Id
    var id: Long = 0

}