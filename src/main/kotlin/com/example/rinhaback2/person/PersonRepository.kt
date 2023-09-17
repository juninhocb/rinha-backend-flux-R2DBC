package com.example.rinhaback2.person

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.*

interface PersonRepository : ReactiveCrudRepository<Person, UUID>{
    @Query("SELECT p FROM Person p WHERE p.nickname LIKE %:criteria% OR p.name LIKE %:criteria% OR p.stack LIKE %:criteria% OR p.bornAt LIKE %:criteria%")
    fun findByCriteria(@Param("criteria") criteria: String): Flux<Person>
}