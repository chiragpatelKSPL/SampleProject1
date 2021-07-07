package com.example.demoapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.databinding.MessageItemBinding
import com.example.demoapp.models.MessageEntity


class MessageAdapter(private val listener: MessageItemListener) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MessageItemBinding = MessageItemBinding.inflate(layoutInflater, parent, false)
        return MessageViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) =
        holder.bind(items.get(position))

    private val items = ArrayList<MessageEntity>()

    fun setItems(items: ArrayList<MessageEntity>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    interface MessageItemListener {
        fun onClick(MessageEntity: MessageEntity)
    }

    class MessageViewHolder(
        private val itemBinding: MessageItemBinding,
        private val listener: MessageItemListener
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(messageEntity: MessageEntity) {
            itemBinding.apply {
                ivAvatar.setImageResource(messageEntity.avatar!!)
                tvUsername.text = messageEntity.name
                tvLastMessage.text = messageEntity.lastMesasge
                tvDate.text = messageEntity.lastMesasgeDate
            }
            itemBinding.root.setOnClickListener {
                listener.onClick(messageEntity)
            }
        }
    }
}
