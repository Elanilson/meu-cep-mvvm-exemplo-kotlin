package com.example.meucepmvvm.listener


interface APIListener<T> {
    fun onSuccess(result : T)
    fun onFailures(mensagem: String)
}