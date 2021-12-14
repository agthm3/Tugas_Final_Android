package com.halil.tugas_final_android.UI.ListCharacter

import android.util.Log
import androidx.lifecycle.ViewModel
import com.halil.tugas_final_android.Model.Character
import com.halil.tugas_final_android.Model.DataCharacter
import com.halil.tugas_final_android.Network.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class ListCharacterViewModel: ViewModel() {
    private val TAG = "ListCharacterViewModel"
    private var listCharacter = mutableListOf<Character>()

    suspend fun getCharacters(adapter: CharacterAdapter) {
        if(listCharacter.isEmpty()) {
            var response: Response<DataCharacter>? = null
            try {
                response = RetrofitClient.instance.getCharacters()
                if(response.isSuccessful) {
                    adapter.setData(response!!.body()!!.data as MutableList<Character>)
                } else {
                    Log.e(TAG, "${response!!.message()}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        } else {
            adapter.setData(listCharacter)
        }
    }

}