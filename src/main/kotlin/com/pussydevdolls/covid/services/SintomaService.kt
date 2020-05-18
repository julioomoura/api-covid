package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.models.Sintoma

interface SintomaService {

    fun retornaSintomas(): MutableIterable<Sintoma>
    fun criaSintoma(nome: String, urlImagem: String): Sintoma
    fun findById(id: Long): Sintoma
}