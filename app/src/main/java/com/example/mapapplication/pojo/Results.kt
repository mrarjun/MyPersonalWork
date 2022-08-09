package com.example.mapapplication.pojo

import com.google.gson.annotations.SerializedName


data class Results(
  @SerializedName("DataProvider") var DataProvider: DataProvider? = null,
  @SerializedName("OperatorInfo") var OperatorInfo: OperatorInfo? = null,
  @SerializedName("UsageType") var UsageType: UsageType? = null,
  @SerializedName("StatusType") var StatusType: StatusType? = null,
  @SerializedName("SubmissionStatus") var SubmissionStatus: SubmissionStatus? = null,
  @SerializedName("PercentageSimilarity") var PercentageSimilarity: String? = null,
  @SerializedName("IsRecentlyVerified") var IsRecentlyVerified: Boolean? = null,
  @SerializedName("DateLastVerified") var DateLastVerified: String? = null,
  @SerializedName("ID") var ID: Int? = null,
  @SerializedName("UUID") var UUID: String? = null,
  @SerializedName("ParentChargePointID") var ParentChargePointID: String? = null,
  @SerializedName("DataProviderID") var DataProviderID: Int? = null,
  @SerializedName("DataProvidersReference") var DataProvidersReference: String? = null,
  @SerializedName("OperatorID") var OperatorID: Int? = null,
  @SerializedName("OperatorsReference") var OperatorsReference: String? = null,
  @SerializedName("UsageTypeID") var UsageTypeID: Int? = null,
  @SerializedName("UsageCost") var UsageCost: String? = null,
  @SerializedName("AddressInfo") var AddressInfo: AddressInfo? = null,
  @SerializedName("Connections") var Connections: ArrayList<Connections> = ArrayList(1),
  @SerializedName("NumberOfPoints") var NumberOfPoints: Int = 0,
  @SerializedName("GeneralComments") var GeneralComments: String? = null,
  @SerializedName("DatePlanned") var DatePlanned: String? = null,
  @SerializedName("DateLastConfirmed") var DateLastConfirmed: String? = null,
  @SerializedName("StatusTypeID") var StatusTypeID: Int? = null,
  @SerializedName("DateLastStatusUpdate") var DateLastStatusUpdate: String? = null,
  @SerializedName("MetadataValues") var MetadataValues: ArrayList<MetaDataValues>? = null,
  @SerializedName("DataQualityLevel") var DataQualityLevel: Int? = null,
  @SerializedName("DateCreated") var DateCreated: String? = null,
  @SerializedName("SubmissionStatusTypeID") var SubmissionStatusTypeID: Int? = null
)