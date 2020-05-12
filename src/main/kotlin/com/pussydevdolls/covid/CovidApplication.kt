package com.pussydevdolls.covid

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class CovidApplication {
	@GetMapping("/hello")
	fun hello() = "Hello World"

}

fun main(args: Array<String>) {
	runApplication<CovidApplication>(*args)
}
