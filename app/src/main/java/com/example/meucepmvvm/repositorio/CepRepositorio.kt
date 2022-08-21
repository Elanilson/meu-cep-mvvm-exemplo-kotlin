package com.example.meucepmvvm.repositorio

import com.example.meucepmvvm.listener.APIListener
import com.example.meucepmvvm.model.Cep
import com.example.meucepmvvm.repositorio.remoto.service.CepService
import com.example.meucepmvvm.repositorio.remoto.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CepRepositorio {
    private val remoto = RetrofitClient.classService(CepService::class.java)

    fun getCep(cep : String,listener: APIListener<Cep>){
        val call = remoto.buscarCep(cep)
        call.enqueue(object : Callback<Cep>{
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                if(response.code() == 200){
                    var meuCep = response.body()!!;
                    listener.onSuccess(meuCep)
                }else{
                    listener.onFailures("cod: ${response.code()} ,"+response.message().toString())
                }

            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                listener.onFailures(t.message.toString())
            }
        })
    }
}