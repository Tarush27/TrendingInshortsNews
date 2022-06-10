package network

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("news")
    fun getNews(@Query("category") newsCategoryName: String)
}