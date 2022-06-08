package com.example.trendinginshortsnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import newsAdapter.NewsAdapter

class InshortsNewsMainActivity : AppCompatActivity() {

    private val newsRecyclerView: RecyclerView
        get() = findViewById(R.id.news_rv)
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inshorts_news_main_activity)
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = NewsAdapter()
        newsRecyclerView.adapter = newsAdapter
    }
}