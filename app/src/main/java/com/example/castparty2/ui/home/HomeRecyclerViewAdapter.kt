package com.example.castparty2.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.castparty2.R
import com.example.castparty2.databinding.HomepageRecyclerviewItemBinding
import com.example.castparty2.model.Content
import com.example.castparty2.model.Podcast
import kotlin.math.min

class HomeRecyclerViewAdapter(val context: Context, val data: List<Content>) :
    RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    var onItemClick: ((Content) -> Unit)? = null
    var onFavouriteItemClick: ((Content) -> Unit)? = null



    inner class ViewHolder(private val binding: HomepageRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.recyclerviewCard.setOnClickListener {
                onItemClick?.invoke(data[adapterPosition])
            }
            binding.favouriteButton.setOnClickListener {
                onFavouriteItemClick?.invoke(data[adapterPosition])
            }
        }

        fun bind(item: Content) {
            binding.rvTitle.text = item.title
            if (item.image != null) {
                Glide.with(context).load(item.image).into(binding.rvImage)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerViewAdapter.ViewHolder {
        val binding: HomepageRecyclerviewItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.homepage_recyclerview_item, parent, false);
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return min(data.size, 10)
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewAdapter.ViewHolder, position: Int) =
        holder.bind(data[position])
}