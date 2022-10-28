package com.example.rest_kotlin.controller

import com.example.rest_kotlin.model.Person
import com.example.rest_kotlin.service.api.PersonServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
class PersonController {

    @Autowired
    lateinit var personServiceAPI: PersonServiceAPI


    @GetMapping("/persons")
    fun getAll(): MutableList<Person>? {
        return personServiceAPI.all
    }

    @PostMapping("/persons")
    fun save(@RequestBody person: Person): ResponseEntity<Person>{
        var obj = personServiceAPI.save(person)
        return ResponseEntity<Person>(person, HttpStatus.OK)
    }

    @DeleteMapping("/persons/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Person>{
        if( personServiceAPI.get(id) != null){
            personServiceAPI.delete(id)
        }else{
            return ResponseEntity<Person>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<Person>(HttpStatus.OK)
    }
}