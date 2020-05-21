package com.pussydevdolls.covid.repositories

import com.pussydevdolls.covid.models.RegistroDeSintoma
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface RegistroDeSintomaRepository: CrudRepository<RegistroDeSintoma, Long> {

    fun findByUsuarioCpfAndSintomaIdAndData(userCpf: String, sintomaId: Long, data: LocalDate): Optional<RegistroDeSintoma>
    fun findByUsuarioCpfAndData(cpf: String, data: LocalDate): Optional<List<RegistroDeSintoma>>
}