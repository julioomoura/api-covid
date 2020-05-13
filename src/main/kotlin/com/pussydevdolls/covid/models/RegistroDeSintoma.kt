package com.pussydevdolls.covid.models

import java.time.LocalDate
import javax.persistence.*

data class RegistroDeSintoma(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val data: LocalDate,
        @ManyToOne
        @JoinColumn(name = "sintoma_id")
        val sintoma: Sintoma,
        @ManyToOne
        @JoinColumn(name = "usuario_id")
        val usuario: Usuario
)