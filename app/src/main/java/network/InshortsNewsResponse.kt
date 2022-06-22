package network

import com.google.gson.annotations.SerializedName
import newsModel.NewsModel

data class NewsResponse(
    @SerializedName("category") var newsCategory: String?,
    @SerializedName("data") var newsList: List<NewsData> = listOf()
) {


    fun returnActualNews(): List<NewsModel> {
        val newsModelList: List<NewsModel> = newsList.map {
            NewsModel(
                category = newsCategory,
                newsAuthor = it.author,
                newsContent = it.content,
                newsImage = it.imageUrl,
                newsTitle = it.title
            )
        }
        return newsModelList
    }
}

data class NewsData(
    @SerializedName("author") var author: String?,
    @SerializedName("content") var content: String?,
    @SerializedName("imageUrl") var imageUrl: String?,
    @SerializedName("title") var title: String?
) {

}