package com.example.meucepmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.meucepmvvm.listener.APIListener
import com.example.meucepmvvm.model.Cep
import com.example.meucepmvvm.repositorio.CepRepositorio

class ExibirEnderecoViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio = CepRepositorio()

    private var _MeuCep = MutableLiveData<Cep>()
    var meuCep : LiveData<Cep> = _MeuCep

    private var _Mensagem = MutableLiveData<String>()
    var mensagem : LiveData<String> = _Mensagem

    fun buscarCep(cep: String){
        val listener = object : APIListener<Cep> {
            override fun onSuccess(result: Cep) {
               _MeuCep.value = result
            }
            override fun onFailures(mensagem: String) {
                _Mensagem.value = mensagem
            }
        }
        repositorio.getCep(cep,listener)

    }
}