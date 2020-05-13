package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.models.RegistroDeSintoma
import com.pussydevdolls.covid.repositories.RegistroDeSintomaRepository
import com.pussydevdolls.covid.repositories.SintomaRepository
import com.pussydevdolls.covid.repositories.UsuarioRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class RegistroDeSintomaService(
    private val repository: RegistroDeSintomaRepository,
    private val usuarioRepository: UsuarioRepository,
    private val sintomaRepository: SintomaRepository
) {

    fun registrarSintoma(cpf: String, id: Long, data: LocalDate): RegistroDeSintoma {
        val usuario = usuarioRepository.findById(cpf)
        val sintoma = sintomaRepository.findById(id)

        val registro = RegistroDeSintoma().apply {
            this.data = data
            this.sintoma = sintoma.get()
            this.usuario = usuario.get()
        }

        return registro
    }
}
