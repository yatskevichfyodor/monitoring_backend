package base.anygame.repository

import base.anygame.model.ActivePlayer
import org.springframework.data.jpa.repository.JpaRepository

interface ActivePlayerRepository: JpaRepository<ActivePlayer, Long> {
    fun findByServerId(id: Long): List<ActivePlayer>
}