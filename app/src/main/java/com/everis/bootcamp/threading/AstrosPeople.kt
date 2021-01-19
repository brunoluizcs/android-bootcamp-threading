package com.everis.bootcamp.threading

import com.google.gson.annotations.SerializedName

//TODO: 007 - Criar classe para representar o astronauta
data class AstrosPeople(
    @SerializedName("craft") val craft: String,
    @SerializedName("name") val name: String
)