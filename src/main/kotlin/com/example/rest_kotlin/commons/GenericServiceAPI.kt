package com.example.rest_kotlin.commons

import java.io.Serializable

interface GenericServiceAPI<T, ID : Serializable?> {
    fun save(entity: T): T
    fun delete(id: ID)
    operator fun get(id: ID): T?
    val all: MutableList<T>?
}