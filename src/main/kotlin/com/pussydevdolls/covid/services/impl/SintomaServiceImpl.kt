package com.pussydevdolls.covid.services.impl

import com.pussydevdolls.covid.models.Sintoma
import com.pussydevdolls.covid.repositories.SintomaRepository
import com.pussydevdolls.covid.services.SintomaService
import org.springframework.stereotype.Service

@Service
class SintomaServiceImpl (
    private val sintomaRepository: SintomaRepository
): SintomaService {

    override fun retornaSintomas() = sintomaRepository.findAll()

    override fun criaSintoma(nome: String): Sintoma {

        val novoSintoma = Sintoma().apply { this.nome = nome.toLowerCase().capitalize() }

        return sintomaRepository.save(novoSintoma)
    }
}
