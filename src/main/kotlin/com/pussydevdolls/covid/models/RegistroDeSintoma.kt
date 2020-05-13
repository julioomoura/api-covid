package com.pussydevdolls.covid.models

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "registro_de_sintoma")
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