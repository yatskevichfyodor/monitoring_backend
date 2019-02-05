package base.anygame.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name="active_players")
data class ActivePlayer (
        @Id
        @GeneratedValue
        val id: Long = 0,

        val name: String = "",

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "server_id", referencedColumnName = "id")
        val server:Server? = null
)