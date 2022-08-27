package com.example.observability.observabilityExample

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import com.example.observability.observabilityExample.dto.ExampleResponse
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(private val exampleService: ExampleService, private val registry: MeterRegistry) {
    private val logger = KotlinLogging.logger {}

    private final val successRequestTotal = Counter.builder("app.example_success_request_total")
        .description("This is a custom counter")
        .tags("method", "get")
        .register(registry)

    private final val successRequestExecutionTimer: Timer = Timer.builder("app.success_request_execution_time")
        .description("This is a custom timer")
        .tags("type", "timer")
        .register(registry)

    private final var responseList: MutableList<ExampleResponse>? =
        registry.gaugeCollectionSize("app.responses_size", emptyList(), mutableListOf())

    @GetMapping(path = ["/exampleSuccess"])
    fun exampleSuccessfulGet() : ExampleResponse? {
        successRequestTotal.increment()

        var response: ExampleResponse? = null

        successRequestExecutionTimer.record {
            response = exampleService.getSuccessfulExampleResponse()

            responseList?.add(response!!)
        }

        logger.info { "response: $response" }

        return response
    }

    @GetMapping(path = ["/exampleFailure"])
    fun exampleFailureGet() : ExampleResponse {
        val response = exampleService.getFailureExampleResponse()
        return response
    }

}