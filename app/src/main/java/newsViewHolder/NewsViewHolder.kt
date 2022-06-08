package newsViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trendinginshortsnews.R

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val newsAvatar: ImageView = itemView.findViewById(R.id.news_avatar)
    val newsTitle: TextView = itemView.findViewById(R.id.news_title)
    val newsAuthor: TextView = itemView.findViewById(R.id.news_author)
    val newsContent: TextView = itemView.findViewById(R.id.news_content)
}
