package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.exceptions.NaoEncontradoException
import com.pussydevdolls.covid.models.Usuario
import com.pussydevdolls.covid.repositories.UsuarioRepository
import com.pussydevdolls.covid.services.impl.UsuarioServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ContextConfiguration(classes = [UsuarioServiceImpl::class])

@ExtendWith(SpringExtension::class)
class UsuarioServiceImplTest {

    @Autowired
    lateinit var service: UsuarioService

    @MockBean
    lateinit var repository: UsuarioRepository

    @BeforeEach
    fun setUp() {
        val usuario = Usuario("cpf")
        Mockito.`when`(repository.findById("cpf"))
                .thenReturn(Optional.of(usuario))

        Mockito.`when`(repository.findById("outrocpf"))
                .thenReturn(Optional.empty())

        Mockito.`when`(repository.findById("novocpf"))
                .thenReturn(Optional.empty())

        Mockito.`when`(repository.save(Usuario("novocpf")))
                .thenReturn(Usuario("novocpf"))
    }

    @Test
    fun `validate creating usuario already existent` () {
        val usuario = service.criaUsuario("cpf")

        assertThat(usuario.cpf).isEqualTo("cpf")
    }

    @Test
    fun `validate creating usuario` () {
        val usuario = service.criaUsuario("novocpf")

        assertThat(usuario.cpf).isEqualTo("novocpf")
    }

    @Test
    fun `validate find by id` () {
        val found = service.findById("cpf")

        assertThat(found).isNotNull
    }

    @Test
    fun `validate find by invalid id throw NaoEncontradoException`() {
        Assertions.assertThrows(NaoEncontradoException::class.java) { service.findById("outrocpf") }
    }
}