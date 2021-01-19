package com.everis.bootcamp.threading

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

//TODO: 010 - Criar a classe responsável por carregar os dados
class AstrosRepository {

    //TODO: 011 - Criar função para carregar os astronautas
    fun loadAstros() : AstrosResult? {
        val client = OkHttpClient()
        val request = Request
            .Builder()
            .url("http://api.open-notify.org/astros.json")
            .build()

        val response = client.newCall(request).execute()
        return parseResultToJson(response.body?.string())
    }

    //TODO: 012 - Criar função para converter o json
    private fun parseResultToJson(body: String?) =
        Gson().fromJson(body, AstrosResult::class.java)

}