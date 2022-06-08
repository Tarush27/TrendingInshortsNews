package newsAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.trendinginshortsnews.R
import newsModel.NewsModel
import newsViewHolder.NewsViewHolder
import news_model_list_singleton.NewsModelList

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {

    private val newsData: ArrayList<NewsModel> = NewsModelList.newsList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val newsViewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_inshorts_news, parent, false)
        return NewsViewHolder(newsViewHolder)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsPosition = newsData[position]
        val activityContext = holder.itemView.context
        Glide.with(activityContext).load(newsPosition.newsImage).into(holder.newsAvatar)
        holder.newsTitle.text = newsPosition.newsTitle
        holder.newsAuthor.text = newsPosition.newsAuthor
        holder.newsContent.text = newsPosition.newsContent
    }

    override fun getItemCount() = newsData.size
}