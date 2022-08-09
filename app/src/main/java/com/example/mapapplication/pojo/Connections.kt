package com.example.mapapplication.pojo

import com.google.gson.annotations.SerializedName


data class Connections(
  @SerializedName("ID") var ID: Int? = null,
  @SerializedName("ConnectionTypeID") var ConnectionTypeID: Int? = null,
  @SerializedName("ConnectionType") var ConnectionType: ConnectionType? = null,
  @SerializedName("Reference") var Reference: String? = null,
  @SerializedName("StatusTypeID") var StatusTypeID: Int? = null,
  @SerializedName("StatusType") var StatusType: StatusType? = null,
  @SerializedName("LevelID") var LevelID: Int? = null,
  @SerializedName("Level") var Level: Level? = null,
  @SerializedName("Amps") var Amps: String? = null,
  @SerializedName("Voltage") var Voltage: String? = null,
  @SerializedName("PowerKW") var PowerKW: Float? = null,
  @SerializedName("CurrentTypeID") var CurrentTypeID: Int? = null,
  @SerializedName("CurrentType") var CurrentType: CurrentType? = null,
  @SerializedName("Quantity") var Quantity: Int? = null,
  @SerializedName("Comments") var Comments: String? = null
)