package com.example.evam3.controller

import com.example.evam3.entity.Characters
import com.example.evam3.service.CharactersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/characters")   //endpoint
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class CharactersController {
    @Autowired
    lateinit var charactersService: CharactersService

    @GetMapping
    fun list ():List <Characters>{
        return charactersService.list()
    }
    @PostMapping
    fun save (@RequestBody characters: Characters): ResponseEntity<Characters> {
        return ResponseEntity(charactersService.save(characters), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody characters: Characters): ResponseEntity<Characters> {
        return ResponseEntity(charactersService.update(characters), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody characters: Characters): ResponseEntity<Characters> {
        return ResponseEntity(charactersService.updateName(characters), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(charactersService.listById (id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return charactersService.delete(id)
    }

}