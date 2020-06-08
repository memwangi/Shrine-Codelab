package com.google.codelabs.mdc.kotlin.shrine

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import kotlinx.android.synthetic.main.shr_product_card.view.*

class ProductCardViewHolder(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    var producImage: NetworkImageView = itemView.product_image
    var productTitle: TextView = itemView.product_title
    var productPrice: TextView = itemView.product_price
}
