package com.pussydevdolls.covid.services.impl

import com.pussydevdolls.covid.dtos.RegistroDeSintomaDTO
import com.pussydevdolls.covid.exceptions.NaoEncontradoException
import com.pussydevdolls.covid.exceptions.NivelInvalidoException
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

        validaNivelDeSintoma(registroDeSintoma.nivel)

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

    override fun retornaRegistroDeSintomaPorUsuarioEData(cpf: String, data: LocalDate): RegistroDeSintoma {
        return repository.findByUsuarioCpfAndData(cpf, data).orElseThrow {
            NaoEncontradoException("Registro de sintoma não encontrado")
        }
    }

    private fun validaNivelDeSintoma(nivel: Int) {
        if (nivel > 5 || nivel < 0) {
            throw NivelInvalidoException("O nível precisa estar entre 0 e 5")
        }
    }

    private fun buscaRegistroPorCpfSintomaIdEData(cpf: String, id: Long, data: LocalDate) = repository.findByUsuarioCpfAndSintomaIdAndData(cpf, id, data)
}
