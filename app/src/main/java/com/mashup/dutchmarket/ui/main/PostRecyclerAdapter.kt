package com.mashup.dutchmarket.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.mashup.dutchmarket.R
import com.mashup.dutchmarket.data.Post
import kotlinx.android.synthetic.main.item_post.view.*


internal class PostRecyclerAdapter : RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder>() {

    private val posts = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostRecyclerAdapter.ViewHolder = ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_post, parent, false))

    override fun getItemCount(): Int = posts.count()

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val post = posts[position]

        Glide.with(viewHolder.itemView)
                .load(post.postImageUrl)
                .apply(RequestOptions().centerCrop())
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(viewHolder.itemView.post_image)

        viewHolder.itemView.post_title.text = post.postTitle
        viewHolder.itemView.post_date.text = post.postDate
        viewHolder.itemView.post_like_prgoress.text = post.postLikeOrProgress.toString()
    }

    fun addPosts(posts: MutableList<Post>) {
        this.posts.clear()
        this.posts.addAll(posts)

        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}