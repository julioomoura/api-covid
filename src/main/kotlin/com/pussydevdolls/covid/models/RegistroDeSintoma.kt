package com.pussydevdolls.covid.models

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
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
        @Cascade(CascadeType.ALL)
        var sintoma: Sintoma? = null
        @ManyToOne
        @JoinColumn(name = "usuario_cpf")
        @Cascade(CascadeType.ALL)
        var usuario: Usuario? = null
}