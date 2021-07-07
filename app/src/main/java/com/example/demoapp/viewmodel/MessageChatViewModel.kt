package com.example.demoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import com.example.demoapp.R
import com.example.demoapp.models.MessageChatEntity
import com.example.demoapp.util.Constants

class MessageChatViewModel(application: Application) : AndroidViewModel(application) {
    val messagesChat: MediatorLiveData<List<MessageChatEntity>> = MediatorLiveData()
    val messageChatList : ArrayList<MessageChatEntity> = ArrayList()

    fun getReadyMessageChat(){
        messageChatList.add(MessageChatEntity("",1,"","","2 Jul 13:34"))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_USER_CHAT,0,"","And we are working from home", "2 Jul 13:34"))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_USER_CHAT,0,"","At our office 3 people are affected.", "2 Jul 13:34"))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_FRIEND_CHAT,0,"","Anybody affected by corona virus?", "2 Jul 13:34", R.drawable.avatar1))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_USER_CHAT,0,"","But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born", "2 Jul 13:34"))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_FRIEND_CHAT,0,"","How is everyone in your family?", "2 Jul 13:34", R.drawable.avatar2))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_FRIEND_CHAT,0,"","A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.", "2 Jul 13:34", R.drawable.avatar3))
        messageChatList.add(MessageChatEntity("",1,"","","8 Jul 10:05"))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_USER_CHAT,0,"","Ohh yes i went there...", "8 Jul 10:05"))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_FRIEND_CHAT,0,"","Have you visited newyork few days back?", "8 Jul 10:05", R.drawable.avatar4))
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_FRIEND_CHAT,0,"","Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.", "8 Jul 10:05", R.drawable.avatar1))
        messagesChat.value = messageChatList
    }

    fun sendNewMessage(newMessage : String){
        messageChatList.add(MessageChatEntity(Constants.CHAT_TYPE_USER_CHAT,0,"",newMessage, "8 Jul 10:05"))
        messagesChat.value = messageChatList
    }
}
