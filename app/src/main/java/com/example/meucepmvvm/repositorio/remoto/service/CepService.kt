package com.example.meucepmvvm.repositorio.remoto.service


import com.example.meucepmvvm.model.Cep
import retrofit2.Call
import retrofit2.http.*

interface CepService {
    @GET("{cep}/json/")
    fun buscarCep(@Path(value = "cep",encoded = true) cep : String ) : Call<Cep>
}