package com.pussydevdolls.covid.repositories

import com.pussydevdolls.covid.models.Usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : CrudRepository<Usuario, String>