package api_client.pojo.auth

open class AuthResetCodePojo {
    //reqBody
    data class AuthResetCodeReqBody(
        val phone: String
    )
}