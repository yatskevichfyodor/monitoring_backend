package base.anygame.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name="games")
data class Game (
        @Id
        @GeneratedValue
        val id: Long = 0,

        val name: String = "",

        @JsonIgnore
        @OneToMany(mappedBy = "game")
        val servers: List<Server>? = null
)