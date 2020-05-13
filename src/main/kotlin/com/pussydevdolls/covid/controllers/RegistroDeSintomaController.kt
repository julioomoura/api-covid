package com.pussydevdolls.covid.controllers

import com.pussydevdolls.covid.dtos.RegistroDeSintomaDTO
import com.pussydevdolls.covid.models.RegistroDeSintoma
import com.pussydevdolls.covid.services.RegistroDeSintomaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class RegistroDeSintomaController (
    private val service: RegistroDeSintomaService
) {
    @PostMapping("/usuarios/{cpf}/sintomas/{id}")
    fun registrarSintoma(@PathVariable cpf: String,
                         @PathVariable id: Long,
                         @RequestBody registroDeSintoma: RegistroDeSintomaDTO
    ): ResponseEntity<RegistroDeSintoma> {
        val novoRegistro = service.registrarSintoma(cpf, id, registroDeSintoma)
        return ResponseEntity(novoRegistro, HttpStatus.CREATED)
    }
}