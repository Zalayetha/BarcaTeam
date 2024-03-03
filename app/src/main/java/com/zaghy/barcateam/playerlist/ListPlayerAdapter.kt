package com.zaghy.barcateam.playerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zaghy.barcateam.databinding.CardViewBinding

class ListPlayerAdapter(private val listPlayer:ArrayList<Player>):RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root)
    private lateinit var onItemCallback:OnItemClickCallback

    fun setOnItemCallback(onItemCallback:OnItemClickCallback) {
        this.onItemCallback = onItemCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListPlayerAdapter.ListViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListPlayerAdapter.ListViewHolder, position: Int) {
        val (name,position,shorDesc,longDesc,photo) = listPlayer[position]
        holder.binding.playerName.text = name
        holder.binding.playerPosition.text = position
        holder.binding.playerDescription.text = shorDesc
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.itemView.setOnClickListener {
            onItemCallback.onItemClicked(listPlayer[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listPlayer.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Player)
    }


}