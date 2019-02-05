package base.anygame.repository

import base.anygame.model.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface GameRepository: JpaRepository<Game, Long>