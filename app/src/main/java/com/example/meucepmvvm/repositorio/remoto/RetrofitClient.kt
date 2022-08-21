package com.example.meucepmvvm.repositorio.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){
    companion object{
        private lateinit var INSTACE : Retrofit
        private fun getInstace() : Retrofit{
            if (!Companion::INSTACE.isInitialized){
                synchronized(this){
                    INSTACE = Retrofit.Builder()
                        .baseUrl("https://viacep.com.br/ws/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return INSTACE
        }
        fun <T> classService(classService: Class<T>) : T {
            return  getInstace().create(classService)
        }
    }
}