package com.pussydevdolls.covid.controllers

import com.pussydevdolls.covid.models.Usuario
import com.pussydevdolls.covid.services.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/login")
@CrossOrigin
class UsuarioController (
    private val usuarioService: UsuarioService
){

    @PostMapping("/{cpf}")
    fun criaUsuario(@PathVariable cpf: String): ResponseEntity<Usuario> {
        val usuario = usuarioService.criaUsuario(cpf)
        return ResponseEntity(usuario, HttpStatus.OK)
    }
}