package bugs.reproduce

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Lesson {
    @Id
    var id: Long = 0

}