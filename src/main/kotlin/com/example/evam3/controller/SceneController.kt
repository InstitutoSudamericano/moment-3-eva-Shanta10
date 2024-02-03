package com.example.evam3.controller

import com.example.evam3.entity.Scene
import com.example.evam3.service.SceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scene")   //endpoint
class SceneController {
    @Autowired
    lateinit var sceneService: SceneService

    @GetMapping
    fun list ():List <Scene>{
        return sceneService.list()
    }
    @PostMapping
    fun save (@RequestBody scene: Scene): ResponseEntity<Scene> {
        return ResponseEntity(sceneService.save(scene), HttpStatus.OK)
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
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(sceneService.listById (id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return sceneService.delete(id)
    }
}