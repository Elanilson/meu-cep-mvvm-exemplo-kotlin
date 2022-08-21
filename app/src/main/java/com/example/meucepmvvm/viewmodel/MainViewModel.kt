package com.example.meucepmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var _Validado = MutableLiveData<Boolean>()
    var validado : LiveData<Boolean> = _Validado

    private var _Mensagem = MutableLiveData<String>()
    var mensagem : LiveData<String> = _Mensagem

    fun validarCampo(cep : String){
        if(cep != null && cep != "" && cep != " "){
          _Validado.value = true
        }else{
            _Mensagem.value = ("Preencha o campo corretamente!")
        }
    }
}