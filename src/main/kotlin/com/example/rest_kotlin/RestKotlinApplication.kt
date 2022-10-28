package com.example.rest_kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class RestKotlinApplication

fun main(args: Array<String>) {
	runApplication<RestKotlinApplication>(*args)
}
