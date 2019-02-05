package base.anygame.controller

import base.anygame.model.ActivePlayer
import base.anygame.repository.ActivePlayerRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/activePlayers")
@CrossOrigin
class ActivePlayerController(private val repository: ActivePlayerRepository) {
    @GetMapping("/get/{serverId}")
    fun getAll(@PathVariable("serverId") serverId: Long): List<ActivePlayer> {
        //return repository.findAllByServerId(serverId)
        return repository.findByServerId(serverId)
    }
}