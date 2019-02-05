package base.anygame.repository

import base.anygame.model.Server
import org.springframework.data.jpa.repository.JpaRepository

interface ServerRepository: JpaRepository<Server, Long>