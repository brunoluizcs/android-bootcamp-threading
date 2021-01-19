package com.everis.bootcamp.threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: 018 - fazer o handle do clique do botão
        button_load_data.setOnClickListener {
            launchAsyncTask()
        }
    }


    //TODO: 013 - Criar função para exibir os dados carregados
    fun showData(astros: List<AstrosPeople>?) {
        textview_data.text = ""
        astros?.forEach { people ->
            textview_data.append("${people.name} - ${people.craft} \n\n\n")
        }
    }

    //TODO: 014 - Criar função para exibir a ProgressBar
    fun showLoadingIndicator(){
        progressbar_load_indicator.visibility = View.VISIBLE
    }

    //TODO: 015 - Criar função para esconder a ProgressBar
    fun hideLoadingIndicator() {
        progressbar_load_indicator.visibility = View.GONE
    }

    //TODO: 017 - Criar função para lançar a Task
    fun launchAsyncTask() {
        AstrosTask().execute()
    }


    //TODO: 016 - Criar classe interna para rodar a tarefa assincrona
    inner class AstrosTask() : AsyncTask<Void, Void, List<AstrosPeople>?>() {
        private val repository = AstrosRepository()

        override fun onPreExecute() {
            super.onPreExecute()
            showLoadingIndicator()
        }

        override fun doInBackground(vararg params: Void?): List<AstrosPeople>? {
            val result = repository.loadAstros()
            return result?.people
        }

        override fun onPostExecute(result: List<AstrosPeople>?) {
            super.onPostExecute(result)
            hideLoadingIndicator()
            showData(result)
        }
    }


}
