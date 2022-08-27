package com.example.observability.observabilityExample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ObservabilityExampleApplication

fun main(args: Array<String>) {
	runApplication<ObservabilityExampleApplication>(*args)
}
