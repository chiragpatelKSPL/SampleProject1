package com.example.demoapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.demoapp.databinding.LayoutDateHeaderBinding
import com.example.demoapp.databinding.LayoutMessageFriendChatItemBinding
import com.example.demoapp.databinding.LayoutMessageUserChatItemBinding
import com.example.demoapp.models.MessageChatEntity
import com.example.demoapp.util.Constants

class MessageChatAdapter : Adapter<ViewHolder>() {

    private var mChatList: ArrayList<MessageChatEntity> = ArrayList()

    fun setItems(aChatList: ArrayList<MessageChatEntity>) {
        mChatList = aChatList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_HEADER) HeaderVH(
            LayoutDateHeaderBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
        else if (viewType == TYPE_USER_CHAT) UserChatVH(
            LayoutMessageUserChatItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
        else if (viewType == TYPE_FRIEND_CHAT) FriendChatVH(
            LayoutMessageFriendChatItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
        else HeaderVH(LayoutDateHeaderBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
        return if (mChatList.get(position).isHeader != 1) {
            if (mChatList.get(position).chatType.equals(Constants.CHAT_TYPE_USER_CHAT)) TYPE_USER_CHAT
            else if (mChatList.get(position).chatType.equals(Constants.CHAT_TYPE_FRIEND_CHAT)) TYPE_FRIEND_CHAT
            else TYPE_DEFAULT
        } else TYPE_HEADER
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val mMessageChat: MessageChatEntity = mChatList.get(position)
        if (mChatList.get(position).isHeader != 1) {
            if (mChatList.get(position).chatType.equals(Constants.CHAT_TYPE_USER_CHAT)) {
                val holder = vh as UserChatVH
                holder.bind(mMessageChat)
            } else if (mChatList.get(position).chatType.equals(Constants.CHAT_TYPE_FRIEND_CHAT)) {
                val holder = vh as FriendChatVH
                holder.bind(mMessageChat)
            }
        } else {
            val holder = vh as HeaderVH
            holder.bind(mMessageChat)
        }
    }

    override fun getItemCount(): Int {
        return mChatList.size
    }

    inner class FriendChatVH(private val itemBinding: LayoutMessageFriendChatItemBinding) :
        ViewHolder(itemBinding.root) {
        fun bind(messageChat: MessageChatEntity?) {
            itemBinding.apply {
                tvFriendMessage.text = messageChat?.message
                ivFriendAvatar.setImageResource(messageChat?.friendAvatar!!)
            }
        }
    }

    inner class UserChatVH(private val itemBinding: LayoutMessageUserChatItemBinding) :
        ViewHolder(itemBinding.root) {
        fun bind(messageChat: MessageChatEntity?) {
            itemBinding.apply {
                tvUserMessage.text = messageChat?.message
            }
        }
    }

    inner class HeaderVH(private val itemBinding: LayoutDateHeaderBinding) :
        ViewHolder(itemBinding.root) {
        fun bind(messageChat: MessageChatEntity?) {
            itemBinding.tvSectionDate.text = messageChat?.sectionDate
        }
    }

    companion object {
        private const val TYPE_HEADER = 1
        private const val TYPE_USER_CHAT = 2
        private const val TYPE_FRIEND_CHAT = 3
        private const val TYPE_DEFAULT = 4
    }

}