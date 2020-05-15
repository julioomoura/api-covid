package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.models.Usuario

interface UsuarioService {
    fun criaUsuario(cpf: String): Usuario
    fun findById(cpf: String): Usuario
}