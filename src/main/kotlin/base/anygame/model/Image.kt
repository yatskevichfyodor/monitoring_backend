package base.anygame.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name="images")
data class Image (
        @Id
        @GeneratedValue
        val id: Long = 0,

        @Lob
        val data: String = "",

        @JsonIgnore
        @OneToMany(mappedBy = "image")
        val servers: List<Server>? = null
)