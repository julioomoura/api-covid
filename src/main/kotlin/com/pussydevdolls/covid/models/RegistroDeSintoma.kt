package com.pussydevdolls.covid.models

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "registro_de_sintoma")
class RegistroDeSintoma{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
        var data: LocalDate? = null
        var nivel: Int = 0
        @ManyToOne
        @JoinColumn(name = "sintoma_id")
        var sintoma: Sintoma? = null
        @ManyToOne
        @JoinColumn(name = "usuario_cpf")
        var usuario: Usuario? = null
}