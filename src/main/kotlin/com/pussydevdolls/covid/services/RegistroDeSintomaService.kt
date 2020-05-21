package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.dtos.RegistroDeSintomaDTO
import com.pussydevdolls.covid.models.RegistroDeSintoma
import java.time.LocalDate

interface RegistroDeSintomaService {
    fun registrarSintoma(cpf: String, id: Long, registroDeSintoma: RegistroDeSintomaDTO): RegistroDeSintoma
    fun retornaRegistroDeSintomaPorUsuarioEData(cpf: String, data: LocalDate): List<RegistroDeSintoma>
}