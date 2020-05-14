package com.pussydevdolls.covid.services.impl

import com.pussydevdolls.covid.dtos.RegistroDeSintomaDTO
import com.pussydevdolls.covid.models.RegistroDeSintoma
import com.pussydevdolls.covid.repositories.RegistroDeSintomaRepository
import com.pussydevdolls.covid.repositories.SintomaRepository
import com.pussydevdolls.covid.repositories.UsuarioRepository
import com.pussydevdolls.covid.services.RegistroDeSintomaService
import org.springframework.stereotype.Service

@Service
class RegistroDeSintomaServiceImpl(
    private val repository: RegistroDeSintomaRepository,
    private val usuarioRepository: UsuarioRepository,
    private val sintomaRepository: SintomaRepository
): RegistroDeSintomaService{

    override fun registrarSintoma(cpf: String, id: Long, registroDeSintoma: RegistroDeSintomaDTO): RegistroDeSintoma {
        val usuario = usuarioRepository.findById(cpf)
        val sintoma = sintomaRepository.findById(id)

        val registro = RegistroDeSintoma().apply {
            this.data = registroDeSintoma.data
            this.nivel = registroDeSintoma.nivel
            this.sintoma = sintoma.get()
            this.usuario = usuario.get()
        }

        return repository.save(registro)
    }
}
