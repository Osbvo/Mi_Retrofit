package com.example.miretrofit.miviewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miretrofit.API.ClimaApI
import com.example.miretrofit.API.InstanciaRetrofit
import com.example.miretrofit.API.NetworkResponse
import com.example.miretrofit.modelos.ClimaModel
import kotlinx.coroutines.launch

class ClimaViewModel: ViewModel() {
    private val climaApI = InstanciaRetrofit().ClimaApi
    private val _climaRes = MutableLiveData<NetworkResponse<ClimaModel>>()
    val resultado = _climaRes
    fun getData(ciudad: String) {
        _climaRes.value = NetworkResponse.loading
        viewModelScope.launch {
            try {

                val res = climaApI.getClima("a197d750469dd4f726710b46a2973014", ciudad, "matric")
                if (res.isSuccessful) {
                    res.body()?.let {
                        _climaRes.value = NetworkResponse.Success(it)

                    }
                }else {
                    _climaRes.value= NetworkResponse.Error("No  se pudieron cargar los datos")
                    }
                } catch (e: Exception){
                    _climaRes.value= NetworkResponse.Error("Un error inesperado acaba de suceder")

            }
        }

    }
}