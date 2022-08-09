package com.example.mapapplication.pojo

import com.google.gson.annotations.SerializedName

data class MetaDataValues(
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("MetadataFieldID") var MetadataFieldID: Int? = null,
    @SerializedName("ItemValue") var ItemValue: String? = null
)
