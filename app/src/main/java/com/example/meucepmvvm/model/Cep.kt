package com.example.meucepmvvm.model

import com.google.gson.annotations.SerializedName

class Cep {
    @SerializedName("cep")
    var cep : String = ""
    @SerializedName("logradouro")
    var logradouro : String = ""
    @SerializedName("complemento")
    var complemento : String = ""
    @SerializedName("bairro")
    var bairro : String = ""
    @SerializedName("localidade")
    var localidade : String = ""
    @SerializedName("uf")
    var uf : String = ""
    @SerializedName("ddd")
    var ddd : String = ""

    override fun toString(): String {
        return "Cep(cep='$cep', logradouro='$logradouro', complemento='$complemento', bairro='$bairro', localidade='$localidade', uf='$uf', ddd='$ddd')"
    }


}