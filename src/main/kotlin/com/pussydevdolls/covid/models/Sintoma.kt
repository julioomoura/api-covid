package com.pussydevdolls.covid.models

import javax.persistence.*

@Entity
class Sintoma {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
        @Column(unique = true)
        var nome: String = ""
        @Column(name = "url_imagem")
        var urlImagem: String = ""
}