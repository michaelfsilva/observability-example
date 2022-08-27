package com.example.observability.observabilityExample

import com.example.observability.observabilityExample.dto.ExampleResponse
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.util.*

@Service
class ExampleService {

    private val logger = KotlinLogging.logger {}

    fun getSuccessfulExampleResponse(): ExampleResponse {
        val exampleResponse = doPrivateBusinessLogicForExampleResponse()

        return exampleResponse
    }

    private fun doPrivateBusinessLogicForExampleResponse(): ExampleResponse {
        val randomStr = UUID.randomUUID().toString()

        val random = Random()
        val randomInt = random.nextInt()

        return ExampleResponse(randomStr, randomInt)
    }

    fun getFailureExampleResponse(): ExampleResponse {
        throw Exception("Super generic Exception")
    }
}