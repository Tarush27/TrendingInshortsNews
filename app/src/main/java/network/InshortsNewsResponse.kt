package network

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("category") var newsCategory: String?,
    @SerializedName("data") var newsList: List<NewsData> = listOf()
) {


}

data class NewsData(
    @SerializedName("author") var author: String?,
    @SerializedName("content") var content: String?,
    @SerializedName("imageUrl") var imageUrl: String?,
    @SerializedName("title") var title: String?
) {

}