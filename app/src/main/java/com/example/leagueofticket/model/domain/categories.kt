package com.example.leagueofticket.model.domain

data class Categories(
    val code: Int,
    val `data`: List<Data>,
    val message: String,
    val success: Boolean
) {
    override fun toString(): String {
        return "Categories(code=$code, `data`=$`data`, message='$message', success=$success)"
    }
}

data class Data(
    val id: Int,
    val title: String
) {
    override fun toString(): String {
        return "Data(id=$id, title='$title')"
    }
}