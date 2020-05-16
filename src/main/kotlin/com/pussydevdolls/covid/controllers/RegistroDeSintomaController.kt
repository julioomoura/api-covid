package com.pussydevdolls.covid.controllers

import com.pussydevdolls.covid.dtos.RegistroDeSintomaDTO
import com.pussydevdolls.covid.models.RegistroDeSintoma
import com.pussydevdolls.covid.services.impl.RegistroDeSintomaServiceImpl
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@CrossOrigin
class RegistroDeSintomaController (
    private val service: RegistroDeSintomaServiceImpl
) {
    @PostMapping("/usuarios/{cpf}/sintomas/{id}")
    fun registrarSintoma(@PathVariable cpf: String,
                         @PathVariable id: Long,
                         @RequestBody registroDeSintoma: RegistroDeSintomaDTO
    ): ResponseEntity<RegistroDeSintoma> {
        val novoRegistro = service.registrarSintoma(cpf, id, registroDeSintoma)
        return ResponseEntity(novoRegistro, HttpStatus.CREATED)
    }

    @GetMapping("/usuarios/{cpf}/sintomas/registros")
    fun retornaRegistroDeSintoma(@PathVariable cpf: String,
                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)@RequestParam data: LocalDate): ResponseEntity<RegistroDeSintoma> {
        val registroDeSintoma = service.retornaRegistroDeSintomaPorUsuarioEData(cpf, data)
        return ResponseEntity(registroDeSintoma, HttpStatus.OK)
    }
}