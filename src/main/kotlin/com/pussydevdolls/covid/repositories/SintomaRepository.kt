package com.pussydevdolls.covid.repositories

import com.pussydevdolls.covid.models.Sintoma
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SintomaRepository: CrudRepository<Sintoma, Long>