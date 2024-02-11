package com.example.evam3.repository

import com.example.evam3.entity.Characters
import com.example.evam3.entity.Film
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface CharactersRepository : JpaRepository<Characters, Long?> {
    fun findById (id: Long?): Characters?

    fun findBySceneId (sceneId:Long?): List <Characters?>

    @Query("SELECT COALESCE(SUM(c.cost), 0) FROM Characters c WHERE c.sceneId = :sceneId")
    fun sumCostBySceneId(@Param("sceneId") sceneId: Long?): BigDecimal?
}
