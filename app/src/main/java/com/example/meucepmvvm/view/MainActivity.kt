package com.example.meucepmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.meucepmvvm.R
import com.example.meucepmvvm.databinding.ActivityMainBinding
import com.example.meucepmvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var campoCep : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonBuscar.setOnClickListener {
            campoCep = binding.editTextCep.text.toString()
            viewModel.validarCampo(campoCep)
        }

        observers()

    }

    private fun observers() {
        viewModel.validado.observe(this){
            if(it){
                irParaProximaTela()
            }
        }
        viewModel.mensagem.observe(this){
            if(it != ""){
                Toast.makeText(this,it, Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun irParaProximaTela(){
        val bundle = Bundle()
        bundle.putString("cep",campoCep)
        val intent = Intent(applicationContext,ExibirEnderecoActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }
}