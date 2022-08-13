package com.example.earth1round_aos.main.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH

interface AuthRetrofitInterface {
    @PATCH("/profile/nickname")
    fun okClick(@Body user:User): Call<AuthResponse>
}