package com.example.evam3.controller

import com.example.evam3.entity.Scene
import com.example.evam3.service.SceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scene")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class SceneController {
    @Autowired
    lateinit var sceneService: SceneService

    @GetMapping
    fun list (): ResponseEntity<List<Scene>> {
        return ResponseEntity(sceneService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody scene: Scene): ResponseEntity<Scene> {
        return ResponseEntity(sceneService.save(scene), HttpStatus.CREATED)
    }

    @PutMapping
    fun update (@RequestBody scene: Scene): ResponseEntity<Scene> {
        return ResponseEntity(sceneService.update(scene), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody scene: Scene): ResponseEntity<Scene> {
        return ResponseEntity(sceneService.updateName(scene), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<Scene?> {
        return ResponseEntity(sceneService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): ResponseEntity<Boolean> {
        val deleted = sceneService.delete(id)
        return if (deleted == true) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
