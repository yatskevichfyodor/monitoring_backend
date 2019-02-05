package base.anygame.controller

import base.anygame.model.User
import base.anygame.model.dto.Credentials
import base.anygame.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
@CrossOrigin
class UserController(private val repository: UserRepository){

    @GetMapping("/get-all")
    fun getAll(): List<User> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): User {
        return repository.findById(id).get()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun post(@RequestBody user: User) =
            repository.save(user)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun put(@RequestBody user: User) =
            repository.save(user)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Long) =
            repository.deleteById(id)

    @GetMapping("/login")
    fun login(@RequestBody user: User): Boolean {
        return user.username == "user" && user.password == "password"
    }

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody credentials: Credentials): Boolean {
        val user = repository.findByUsername(credentials.username)
        return (user != null && user.password == credentials.password)
    }
}