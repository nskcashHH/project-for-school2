package api_client

import ResponseType
import api_client.environment.Environment.headers
import com.google.gson.Gson
import io.qameta.allure.Attachment
import io.restassured.RestAssured.given
import io.restassured.response.Response


interface Post : Res, Allure {
    val resBody: Any

    fun post(reqBody: Any)

    fun postReq(
        endPoint: String,
        reqBody: Any,
        responseType: ResponseType
    ): Response {
        val response = given()
            .headers(headers)
            .body(reqBody)
            .`when`().log().all()
            .post(endPoint)
            .then().log().all()
            .extract().response()

        if (responseType == ResponseType.JSON) {
            super.getDataFromJSON(response)
            super.attachResBody(getDataFromJSON(response))
        } else super.attachResBody(response.body.asString())

        super.attachStatusCode(response.statusCode)

        return response
    }

}

interface Get : Res, Allure {
    val resBody: Any
    fun get(queryParams: MutableMap<String, String>)
    fun getReq(
        endPoint: String,
        queryParams: MutableMap<String, String> = mutableMapOf(),
        responseType: ResponseType
    ): Response {

        val response = given()
            .headers(headers)
            .queryParams(queryParams)
            .`when`().log().all()
            .get(endPoint)
            .then().log().all()
            .extract().response()

        if (responseType == ResponseType.JSON) {
            super.getDataFromJSON(response)
            super.attachResBody(getDataFromJSON(response))
        } else super.attachResBody(response.body.asString())

        super.attachStatusCode(response.statusCode)

        return response
    }

}

interface Res {

    fun getDataFromJSON(response: Response): Any {
        val jsonString = response.toString()
        val gson = Gson()
        return gson.fromJson(jsonString, Any::class.java)
    }

}

interface Allure {
    // Преобразование ответа из class в json и приложение его к отчету
    @Attachment(value = "Response", type = "application/json")
    fun attachResBody(res: Any): String? {
        val gson = Gson()
        return gson.toJson(res)
    }

    // Приложение кода ответа к отчету
    @Attachment(value = "Status Code", type = "application/json")
    fun attachStatusCode(status: Int): Int {
        return status
    }
}