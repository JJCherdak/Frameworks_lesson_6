package ru.geekbrains.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubUser(
    @SerializedName ("id")
    val id: String,
    @SerializedName ("login")
    val login: String? = null,
    @SerializedName ("avatar_url")
    val avatarUrl: String? = null
) : Parcelable
