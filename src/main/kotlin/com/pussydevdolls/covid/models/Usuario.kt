package com.pussydevdolls.covid.models

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Usuario(
        @Id
        @CPF
        val cpf: String
)