package com.example.evam3.entity

import jakarta.persistence.*

@Entity
@Table(name="characters")
class Characters {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var cost: Double? = null
    @Column(name="scene_id")
    var sceneId: Long? = null
}
