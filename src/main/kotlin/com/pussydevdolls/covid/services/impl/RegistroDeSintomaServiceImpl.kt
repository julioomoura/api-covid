package com.pussydevdolls.covid.services.impl

import com.pussydevdolls.covid.dtos.RegistroDeSintomaDTO
import com.pussydevdolls.covid.exceptions.RegistroDeSintomaJaExisteException
import com.pussydevdolls.covid.models.RegistroDeSintoma
import com.pussydevdolls.covid.repositories.RegistroDeSintomaRepository
import com.pussydevdolls.covid.services.RegistroDeSintomaService
import com.pussydevdolls.covid.services.SintomaService
import com.pussydevdolls.covid.services.UsuarioService
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class RegistroDeSintomaServiceImpl(
    private val repository: RegistroDeSintomaRepository,
    private val usuarioService: UsuarioService,
    private val sintomaService: SintomaService
): RegistroDeSintomaService{

    override fun registrarSintoma(cpf: String, id: Long, registroDeSintoma: RegistroDeSintomaDTO): RegistroDeSintoma {
        val usuario = usuarioService.findById(cpf)
        val sintoma = sintomaService.findById(id)

        buscaRegistroPorCpfSintomaIdEData(cpf, id, registroDeSintoma.data!!).ifPresent {
            throw RegistroDeSintomaJaExisteException("Já existe um registro nessa data para esse usuário e sintoma")
        }

        val registro = RegistroDeSintoma().apply {
            this.data = registroDeSintoma.data
            this.nivel = registroDeSintoma.nivel
            this.sintoma = sintoma
            this.usuario = usuario
        }

        return repository.save(registro)
    }

    private fun buscaRegistroPorCpfSintomaIdEData(cpf: String, id: Long, data: LocalDate) = repository.findByUsuarioCpfAndSintomaIdAndData(cpf, id, data)
}
