package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.models.Usuario
import com.pussydevdolls.covid.repositories.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (
    private val usuarioRepository: UsuarioRepository
){

    fun criaUsuario(cpf: String): Usuario {
        val usuario = usuarioRepository.findById(cpf)

        return when (usuario.isPresent) {
            false -> usuarioRepository.save(Usuario(cpf))
            true -> usuario.get()
        }
    }
}
