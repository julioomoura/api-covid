package com.pussydevdolls.covid.services.impl

import com.pussydevdolls.covid.models.Usuario
import com.pussydevdolls.covid.repositories.UsuarioRepository
import com.pussydevdolls.covid.services.UsuarioService
import org.springframework.stereotype.Service

@Service
class UsuarioServiceImpl (
    private val usuarioRepository: UsuarioRepository
): UsuarioService {

    override fun criaUsuario(cpf: String): Usuario {
        val usuario = usuarioRepository.findById(cpf)

        return when (usuario.isPresent) {
            false -> usuarioRepository.save(Usuario(cpf))
            true -> usuario.get()
        }
    }
}
