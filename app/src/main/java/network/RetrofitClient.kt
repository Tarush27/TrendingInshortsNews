package network

import constants.INSHORTS_NEWS_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(INSHORTS_NEWS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val newsService: NewsApiService = retrofit.create(NewsApiService::class.java)
}