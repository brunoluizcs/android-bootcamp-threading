package com.everis.bootcamp.threading

import com.google.gson.annotations.SerializedName

//TODO: 009 Criar classe para representar o resultado da api
data class AstrosResult(
    @SerializedName("message") val message: String,
    @SerializedName("number") val number: Int,
    @SerializedName("people") val people: List<AstrosPeople>
)