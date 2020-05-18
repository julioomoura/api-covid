package com.pussydevdolls.covid.controllers

import com.pussydevdolls.covid.dtos.SintomaDTO
import com.pussydevdolls.covid.models.Sintoma
import com.pussydevdolls.covid.services.impl.SintomaServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sintomas")
@CrossOrigin
class SintomaController (
    private val sintomaService: SintomaServiceImpl
){

    @GetMapping
    fun retornaSintomas(): ResponseEntity<MutableIterable<Sintoma>> {
        val sintomas = sintomaService.retornaSintomas()
        return ResponseEntity(sintomas, HttpStatus.OK)
    }

    @PostMapping
    fun criaSintoma(@RequestBody sintoma: SintomaDTO): ResponseEntity<Sintoma> {
        val sintoma = sintomaService.criaSintoma(sintoma.nome, sintoma.urlImagem)
        return ResponseEntity(sintoma, HttpStatus.CREATED)
    }

}