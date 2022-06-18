package network

import android.util.Log
import com.google.gson.annotations.SerializedName
import constants.NEWS_TAG

data class NewsResponse(
    @SerializedName("category") var category: String?,
    @SerializedName("data") var newsList: ArrayList<NewsData> = arrayListOf()
) {
    fun fetchNews() {
        for (news in newsList) {
            Log.d(NEWS_TAG, "news content : $news")
        }
    }
}

data class NewsData(
    @SerializedName("author") var author: String?,
    @SerializedName("content") var content: String?,
    @SerializedName("imageUrl") var imageUrl: String?,
    @SerializedName("title") var title: String?
) {

}