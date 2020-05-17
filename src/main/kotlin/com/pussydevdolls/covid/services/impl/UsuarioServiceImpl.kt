package com.pussydevdolls.covid.services.impl

import com.pussydevdolls.covid.exceptions.NaoEncontradoException
import com.pussydevdolls.covid.models.Usuario
import com.pussydevdolls.covid.repositories.UsuarioRepository
import com.pussydevdolls.covid.services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioServiceImpl: UsuarioService {

    @Autowired
    private lateinit var repository: UsuarioRepository

    override fun criaUsuario(cpf: String): Usuario {
        val usuario = repository.findById(cpf)

        return when (usuario.isPresent) {
            false -> repository.save(Usuario(cpf))
            true -> usuario.get()
        }
    }

    override fun findById(cpf: String): Usuario {
        return repository.findById(cpf).orElseThrow {
            NaoEncontradoException("Usuário não encontrado")
        }
    }
}
