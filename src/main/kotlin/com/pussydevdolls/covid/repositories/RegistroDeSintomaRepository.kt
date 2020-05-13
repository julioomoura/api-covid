package com.pussydevdolls.covid.repositories

import com.pussydevdolls.covid.models.RegistroDeSintoma
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RegistroDeSintomaRepository: CrudRepository<RegistroDeSintoma, Long>