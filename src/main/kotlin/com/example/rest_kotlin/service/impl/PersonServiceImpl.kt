package com.example.rest_kotlin.service.impl

import com.example.rest_kotlin.commons.GenericServiceImpl
import com.example.rest_kotlin.model.Person
import com.example.rest_kotlin.repository.PersonRepository
import com.example.rest_kotlin.service.api.PersonServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl : GenericServiceImpl<Person, Long>(), PersonServiceAPI {

    @Autowired
    lateinit var personRepository: PersonRepository

    override fun getDao(): CrudRepository<Person, Long> {
        return personRepository
    }
}