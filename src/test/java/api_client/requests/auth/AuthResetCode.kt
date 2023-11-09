package api_client.requests.auth

import ResponseType
import api_client.Post
import api_client.Res
import api_client.pojo.auth.AuthResetCodePojo
import io.restassured.response.Response

object AuthResetCode : Post, Res, AuthResetCodePojo() {

    override lateinit var resBody: String

    override fun getDataFromJSON(response: Response): String {
        return response.body.asString()
    }

    // Создание body POST запроса
    fun authResetCodeReqBody(phone: String): AuthResetCodeReqBody {
        return AuthResetCodeReqBody(phone = phone)
    }

    // отправка запроса POST auth/anonymous
    override fun post(reqBody: Any) {
        val responseJSON = postReq(
            endPoint = "добавить",
            reqBody = reqBody,
            responseType = ResponseType.HTML
        )
        // перенос ответа по классам для дальнейшей обработки
        resBody = getDataFromJSON(responseJSON)
    }
}