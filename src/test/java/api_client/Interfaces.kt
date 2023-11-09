package api_client

import ResponseType
import api_client.environment.Environment.headers
import com.google.gson.Gson
import io.restassured.RestAssured.given
import io.restassured.response.Response


interface Post : Res {
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
        }

        return response
    }

}

interface Get : Res {
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
        }

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