package com.example.evam3.repository

import com.example.evam3.entity.Scene
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface SceneRepository : JpaRepository<Scene, Long?> {
    fun findById (id: Long?): Scene?

    @Query("SELECT COALESCE(SUM(s.minutes), 0) FROM Scene s WHERE s.filmId = :filmId")
    fun sumDurationByFilmId(filmId: Long?): BigInteger?
}