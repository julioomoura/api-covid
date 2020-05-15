package com.pussydevdolls.covid.repositories

import com.pussydevdolls.covid.models.Sintoma
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SintomaRepository: CrudRepository<Sintoma, Long> {
    fun findByNome(nome: String): Optional<Sintoma>
}