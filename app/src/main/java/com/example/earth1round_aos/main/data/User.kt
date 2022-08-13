package com.example.earth1round_aos.main.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "email") var email: String = "",
    @SerializedName(value = "name") var name: String = "",
    @SerializedName(value = "char") var char: Int = 0,
    @SerializedName(value = "course") var course: Int = 0
)
