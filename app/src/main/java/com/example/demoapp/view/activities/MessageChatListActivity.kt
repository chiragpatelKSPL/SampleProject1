package com.example.demoapp.view.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.databinding.ActivityMessageChatListBinding
import com.example.demoapp.models.MessageChatEntity
import com.example.demoapp.view.adapters.MessageChatAdapter
import com.example.demoapp.viewmodel.MessageChatViewModel

class MessageChatListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageChatListBinding
    private val vmMessageChat: MessageChatViewModel by viewModels()
    private lateinit var mAdapter: MessageChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding = ActivityMessageChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inIt()
    }

    private fun inIt() {
        mAdapter = MessageChatAdapter()
        val layoutManager = LinearLayoutManager(this)
        binding.apply {
            rvChatMessages.layoutManager = layoutManager
            rvChatMessages.adapter = mAdapter
        }
        vmMessageChat.getReadyMessageChat()
        vmMessageChat.messagesChat.observe(this, {
            mAdapter.setItems(it as ArrayList<MessageChatEntity>)
            binding.rvChatMessages.smoothScrollToPosition(it.size-1)
        })

        binding.ivSendMessage.setOnClickListener {
            vmMessageChat.sendNewMessage(binding.edtMessage.text.toString())
            binding.edtMessage.setText("")
        }
    }
}