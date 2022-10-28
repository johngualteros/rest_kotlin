package com.example.rest_kotlin.repository

import com.example.rest_kotlin.model.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository :  CrudRepository<Person, Long> {
}