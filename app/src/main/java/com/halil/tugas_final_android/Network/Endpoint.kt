package com.halil.tugas_final_android.Network

import com.halil.tugas_final_android.Model.DataCharacter
import retrofit2.Response
import retrofit2.http.GET

interface Endpoint {

    @GET("/agents")
    suspend fun getCharacters(): Response<DataCharacter>

}