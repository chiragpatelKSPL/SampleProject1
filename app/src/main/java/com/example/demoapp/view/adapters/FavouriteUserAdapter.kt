package com.example.demoapp.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.databinding.FavouriteUserItemBinding
import com.example.demoapp.models.UserEntity


class FavouriteUserAdapter :
    RecyclerView.Adapter<FavouriteUserAdapter.FavouriteUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteUserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FavouriteUserItemBinding.inflate(layoutInflater, parent, false)

        return FavouriteUserViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FavouriteUserViewHolder, position: Int) =
        holder.bind(items.get(position))

    private val items = ArrayList<UserEntity>()

    fun setItems(items: ArrayList<UserEntity>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class FavouriteUserViewHolder(
        private val itemBinding: FavouriteUserItemBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(userEntity: UserEntity) {
            itemBinding.apply {
                ivAvatar.setImageResource(userEntity.avatar!!)
                tvFavUserName.text = userEntity.name
            }
        }
    }
}
