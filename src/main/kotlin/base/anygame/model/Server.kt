package base.anygame.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.annotation.PostConstruct
import javax.persistence.*

@Entity
@Table(name = "servers")
data class Server(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val name: String = "",

        val ip: String = "",

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "game_id", referencedColumnName = "id")
        val game: Game? = null,

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "image_id", referencedColumnName = "id")
        val image: Image? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "server")
        val activePlayers: List<ActivePlayer>? = null,

        val maxPlayersNumber: Int = 0,

        // TODO: лениво получить количество активных игроков запросом в базу
        var activePlayersNumber: Int = 0,

        @Temporal(TemporalType.TIMESTAMP)
        val timestamp: Date = Date()
)