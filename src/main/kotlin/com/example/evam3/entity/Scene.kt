package com.example.evam3.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.math.BigInteger

@Entity
@Table(name="scene")
class Scene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var budget: BigDecimal? = null
    var minutes: BigInteger? = null
    @Column(name="film_id")
    var filmId: Long? = null
}