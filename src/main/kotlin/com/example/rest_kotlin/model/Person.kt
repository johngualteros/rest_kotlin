package com.example.rest_kotlin.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column
    val name: String = "",
    @Column
    val lastname: String = "",
    @Column
    val address: String = "",
    @Column
    val telephone: String = ""){}
