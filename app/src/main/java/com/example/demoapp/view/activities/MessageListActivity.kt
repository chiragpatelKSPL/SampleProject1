package com.example.demoapp.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.databinding.ActivityMessageListBinding
import com.example.demoapp.models.MessageEntity
import com.example.demoapp.models.UserEntity
import com.example.demoapp.view.adapters.FavouriteUserAdapter
import com.example.demoapp.view.adapters.MessageAdapter
import com.example.demoapp.viewmodel.MessagesViewModel

class MessageListActivity : AppCompatActivity(), MessageAdapter.MessageItemListener {

    private lateinit var binding: ActivityMessageListBinding
    private val vmMessages: MessagesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding = ActivityMessageListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inItFavUserList()
        inItMessageList()
    }

    private fun inItFavUserList() {
        val mFavUserAdapter = FavouriteUserAdapter()
        val horizontalLayoutManager = LinearLayoutManager(
            this@MessageListActivity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.apply {
            rvFavourites.layoutManager = horizontalLayoutManager
            rvFavourites.adapter = mFavUserAdapter
        }
        vmMessages.addFavUsers()
        vmMessages.favUsers.observe(this, {
            mFavUserAdapter.setItems(it as ArrayList<UserEntity>)
        })
    }

    private fun inItMessageList() {
        val mMessageAdapter = MessageAdapter(this)
        val layoutManager = LinearLayoutManager(this)
        binding.apply {
            rvMessages.layoutManager = layoutManager
            rvMessages.adapter = mMessageAdapter
        }
        vmMessages.addMessages()
        vmMessages.allMessages.observe(this, {
            mMessageAdapter.setItems(it as ArrayList<MessageEntity>)
        })
    }

    override fun onClick(MessageEntity: MessageEntity) {
        startActivity(Intent(this@MessageListActivity, MessageChatListActivity::class.java))
    }

}