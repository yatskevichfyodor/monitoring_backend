package base.anygame.controller

import base.anygame.model.Game
import base.anygame.repository.GameRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/game")
@CrossOrigin
class GameController(private val repository: GameRepository) {
    @GetMapping("/get-all")
    fun getAll(): List<Game> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Game {
        return repository.findById(id).get()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun post(@RequestBody game: Game) =
            repository.save(game)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun put(@RequestBody game: Game) =
        repository.save(game)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Long) =
        repository.deleteById(id)
}
