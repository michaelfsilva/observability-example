package com.example.observability.observabilityExample.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy::class)
data class ExampleResponse(
    val exampleString: String,
    val exampleInt: Int
)
