package com.mashup.dutchmarket.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.mashup.dutchmarket.R
import com.mashup.dutchmarket.data.PopularPost
import kotlinx.android.synthetic.main.fragment_popular_post.*

private const val ITEM_POPULAR_POST= "item_popular_post"

internal class PopularPostFragment : Fragment() {

    private var popularPost: PopularPost? = null

    companion object {
        @JvmStatic
        fun newInstance(popularPost: PopularPost) = PopularPostFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ITEM_POPULAR_POST, popularPost)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            popularPost = it.getParcelable(ITEM_POPULAR_POST)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(
            R.layout.fragment_popular_post,
            container,
            false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
                .load(popularPost?.postImageUrl)
                .apply(RequestOptions().centerCrop())
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(popular_post_image)

        popular_post_title.text = popularPost?.postTitle
    }
}
