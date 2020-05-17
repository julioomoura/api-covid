package com.pussydevdolls.covid.services.impl

import com.pussydevdolls.covid.exceptions.NaoEncontradoException
import com.pussydevdolls.covid.models.Sintoma
import com.pussydevdolls.covid.repositories.SintomaRepository
import com.pussydevdolls.covid.services.SintomaService
import org.springframework.stereotype.Service

@Service
class SintomaServiceImpl (
    private val repository: SintomaRepository
): SintomaService {

    override fun retornaSintomas() = repository.findAll()

    override fun criaSintoma(nome: String, urlImagem: String): Sintoma {

        val nomeCapitalized = nome.toLowerCase().capitalize()

        val sintomaFromDB = repository.findByNome(nomeCapitalized)

        return when(sintomaFromDB.isPresent) {
            true -> sintomaFromDB.get()
            false -> repository.save(Sintoma().apply {
                this.nome = nomeCapitalized
                this.urlImagem = urlImagem
            })
        }
    }

    override fun findById(id: Long): Sintoma {
        return repository.findById(id).orElseThrow {
            throw NaoEncontradoException("Sintoma não encontrado")
        }
    }
}
