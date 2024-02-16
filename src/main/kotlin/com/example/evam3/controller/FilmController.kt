package com.example.evam3.controller

import com.example.evam3.entity.Film
import com.example.evam3.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/film")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class FilmController {
    @Autowired
    lateinit var filmService: FilmService

    @GetMapping
    fun list (): ResponseEntity<List<Film>> {
        return ResponseEntity(filmService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.save(film), HttpStatus.CREATED)
    }

    @PutMapping
    fun update (@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.update(film), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.updateName(film), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<Film?> {
        return ResponseEntity(filmService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete (@PathVariable("id") id: Long): ResponseEntity<Boolean> {
        val deleted = filmService.delete(id)
        return if (deleted == true) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}