package api_client.pojo

import com.google.gson.annotations.SerializedName

open class CategoriesPojo {

    data class CategoriesRes(
        @SerializedName("code") var code: String? = null,
        @SerializedName("status") var status: String? = null,
        @SerializedName("name") var name: String? = null,
        @SerializedName("description") var description: ArrayList<String> = arrayListOf(),
        @SerializedName("logo") var logo: String? = null,
        @SerializedName("blackTheme") var blackTheme: Boolean? = null,
        @SerializedName("sortIndex") var sortIndex: Int? = null,
        @SerializedName("createdAt") var createdAt: String? = null,
        @SerializedName("updatedAt") var updatedAt: String? = null,
        @SerializedName("parents") var parents: ArrayList<String> = arrayListOf(),
        @SerializedName("banners") var banners: ArrayList<String> = arrayListOf(),
        @SerializedName("accessibility") var accessibility: String? = null,
        @SerializedName("invertTheme") var invertTheme: Boolean? = null
    )
}