package base.anygame.repository

import base.anygame.model.Image
import org.springframework.data.jpa.repository.JpaRepository

interface ImageRepository: JpaRepository<Image, Long>