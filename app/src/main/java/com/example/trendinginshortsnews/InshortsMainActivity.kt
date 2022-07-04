package com.example.trendinginshortsnews

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import network.NewsApiService
import network.NewsData
import network.NewsResponse
import network.RetrofitClient
import newsAdapter.NewsAdapter
import newsModel.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InshortsMainActivity : AppCompatActivity() {

    private val newsRecyclerView: RecyclerView
        get() = findViewById(R.id.news_rv)
    private lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inshorts_news_main_activity)
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = NewsAdapter()
        newsRecyclerView.adapter = newsAdapter
        getNewsContent()
    }

    private fun getNewsContent() {
        val initNewsService: NewsApiService = RetrofitClient.newsService
        val fetchNewsByCategory: Call<NewsResponse> = initNewsService.getNews("")
        fetchNewsByCategory.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {

                    val newsResponse: NewsResponse? = response.body()
                    val newsModels: List<NewsModel>? = newsResponse?.newsList?.map { it: NewsData ->
                        NewsModel(
                            category = newsResponse.newsCategory,
                            newsContent = it.content,
                            newsImage = it.imageUrl,
                            newsTitle = it.title,
                            newsAuthor = it.author
                        )
                    }

                    newsAdapter.updateNews(newsModels as ArrayList<NewsModel>?)

                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d("InshortsMainActivity", "onFailure: ${t.message}")
            }

        })
    }
}