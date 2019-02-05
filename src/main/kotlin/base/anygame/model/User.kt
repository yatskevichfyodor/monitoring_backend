package base.anygame.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name="users")
data class User (
        @Id
        @GeneratedValue
        val id: Long = 0,

        val username: String = "",

        val email: String = "",

        val password: String = "",

        @Temporal(TemporalType.TIMESTAMP)
        val timestamp : Date = Date()
)