package com.hammad.growiser.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "fields")
data class Field(
    @ColumnInfo(name = "id") @SerializedName("id") val id: String,
    @ColumnInfo(name = "name") @SerializedName("name") val name: String,
    @ColumnInfo(name = "type") @SerializedName("type") val type: String
)