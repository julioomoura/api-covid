package com.pussydevdolls.covid.models

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Sintoma (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var nome: String
)