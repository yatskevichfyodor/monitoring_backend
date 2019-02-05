package base.anygame.controller

import base.anygame.model.Image
import base.anygame.model.Server
import base.anygame.model.dto.ServerDto
import base.anygame.repository.GameRepository
import base.anygame.repository.ImageRepository
import base.anygame.repository.ServerRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/server")
@CrossOrigin
class ServerController(private val repository: ServerRepository, private val gameRepository: GameRepository, private val imageRepository: ImageRepository) {
    @GetMapping("/get-all")
    fun getAll(): List<ServerDto> {
        return repository.findAll().map{ServerDto(id = it.id, name = it.name, ip = it.ip, gameId = it.game!!.id, gameName = it.game.name, imageData = it.image!!.data, maxPlayersNumber = it.maxPlayersNumber)}
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ServerDto {
        val server = repository.findById(id).get()
        return ServerDto(id = server.id, name = server.name, ip = server.ip, gameId = server.game!!.id, gameName = server.game.name, imageData = server.image!!.data, maxPlayersNumber = server.maxPlayersNumber)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun post(@RequestBody serverDto: ServerDto){
        val image = imageRepository.save(Image(data = serverDto.imageData))
        repository.save(Server(name = serverDto.name, ip = serverDto.ip, game = gameRepository.findById(serverDto.gameId).get(), image = image, maxPlayersNumber = serverDto.maxPlayersNumber))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun put(@RequestBody serverDto: ServerDto){
        imageRepository.deleteById(repository.findById(serverDto.id).get().image!!.id)
        val image = imageRepository.save(Image(data = serverDto.imageData))
        repository.save(Server(id = serverDto.id, name = serverDto.name, ip = serverDto.ip, game = gameRepository.findById(serverDto.gameId).get(), image = image, maxPlayersNumber = serverDto.maxPlayersNumber))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) =
        repository.deleteById(id)
}