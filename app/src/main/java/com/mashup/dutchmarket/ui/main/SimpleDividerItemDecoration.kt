package com.mashup.dutchmarket.ui.main

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.mashup.dutchmarket.DutchMarket
import com.mashup.dutchmarket.R


internal class SimpleDividerItemDecoration : RecyclerView.ItemDecoration() {

    private val mDivider: Drawable? = ContextCompat.getDrawable(DutchMarket.instance, R.drawable.line_divider)


    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(canvas, parent, state)

        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for(i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider?.intrinsicHeight!!

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(canvas)
        }
    }
}