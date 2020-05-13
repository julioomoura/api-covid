package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.models.Sintoma
import com.pussydevdolls.covid.repositories.SintomaRepository
import org.springframework.stereotype.Service

@Service
class SintomaService (
    private val sintomaRepository: SintomaRepository
) {

    fun retornaSintomas() = sintomaRepository.findAll()

    fun criaSintoma(nome: String): Sintoma {

        val novoSintoma = Sintoma().apply { this.nome = nome.toLowerCase().capitalize() }

        return sintomaRepository.save(novoSintoma)
    }

}
