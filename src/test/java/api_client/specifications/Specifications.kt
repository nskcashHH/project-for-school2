package api_client.specifications

import io.restassured.RestAssured.requestSpecification
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification

object Specifications {
    fun requestSpec(url: String): RequestSpecification {
        return RequestSpecBuilder()
            .setBaseUri(url)
            .setContentType(ContentType.JSON)
            .build()
    }

    fun installSpecification(requestSpec: RequestSpecification) {
        requestSpecification = requestSpec
    }
}