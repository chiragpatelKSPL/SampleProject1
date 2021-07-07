package com.example.demoapp.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = MessageEntity.TABLE_NAME)
data class MessageEntity(

    @ColumnInfo(name = NAME)
    val name: String? = "",

    @ColumnInfo(name = LAST_MESSAGE)
    val lastMesasge: String? = "",

    @ColumnInfo(name = LAST_MESSAGE_DATE)
    val lastMesasgeDate: String? = "",

    @ColumnInfo(name = AVATAR_IMAGE)
    val avatar: Int? = 0

) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id: Int? = null

    companion object {
        const val TABLE_NAME = "messages"
        const val ID = "id"
        const val NAME = "name"
        const val LAST_MESSAGE = "lastMessage"
        const val LAST_MESSAGE_DATE = "lastMesasgeDate"
        const val AVATAR_IMAGE = "avatar"
        const val USERS = "users"
    }
}
