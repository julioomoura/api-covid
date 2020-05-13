package com.pussydevdolls.covid.controllers

import com.pussydevdolls.covid.models.RegistroDeSintoma
import com.pussydevdolls.covid.services.RegistroDeSintomaService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
class RegistroDeSintomaController (
    private val service: RegistroDeSintomaService
) {
    @PostMapping("/usuarios/{cpf}/sintomas/{id}")
    fun registrarSintoma(@PathVariable cpf: String,
                         @PathVariable id: Long,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) data: LocalDate
    ): ResponseEntity<RegistroDeSintoma> {
        val novoRegistro = service.registrarSintoma(cpf, id, data)
        return ResponseEntity(novoRegistro, HttpStatus.CREATED)
    }
}