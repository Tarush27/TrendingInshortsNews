package network

import constants.INSHORTS_NEWS_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit = Retrofit.Builder()
        .baseUrl(INSHORTS_NEWS_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}