package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.dtos.RegistroDeSintomaDTO
import com.pussydevdolls.covid.models.RegistroDeSintoma

interface RegistroDeSintomaService {
    fun registrarSintoma(cpf: String, id: Long, registroDeSintoma: RegistroDeSintomaDTO): RegistroDeSintoma
}