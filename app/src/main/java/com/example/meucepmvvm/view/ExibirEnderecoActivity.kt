package com.example.meucepmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.meucepmvvm.R
import com.example.meucepmvvm.databinding.ActivityExibirEnderecoBinding
import com.example.meucepmvvm.viewmodel.ExibirEnderecoViewModel

class ExibirEnderecoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExibirEnderecoBinding
    private lateinit var viewModel: ExibirEnderecoViewModel
    private var cep : String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExibirEnderecoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        viewModel = ViewModelProvider(this).get(ExibirEnderecoViewModel::class.java)

        observers()
    }

    private fun observers() {
        viewModel.meuCep.observe(this){
            binding.textViewCep.setText(it.cep)
            binding.textViewBairro.setText(it.bairro)
            binding.textViewLogradouro.setText(it.logradouro)
            binding.textViewComplemento.setText(it.complemento)
            binding.textViewLocalidade.setText(it.localidade)
            binding.textView2Uf.setText(it.uf)
            binding.textViewDDD.setText(it.ddd)
        }
        viewModel.mensagem.observe(this){
            Toast.makeText(applicationContext,it, Toast.LENGTH_SHORT).show()

        }
    }

    override fun onResume() {
        super.onResume()
        val bundle = intent.extras
        if(bundle != null){
            cep = bundle.getString("cep")!!
            viewModel.buscarCep(cep)
        }

    }
}