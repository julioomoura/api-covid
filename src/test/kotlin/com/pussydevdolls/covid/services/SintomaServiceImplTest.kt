package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.exceptions.NaoEncontradoException
import com.pussydevdolls.covid.models.Sintoma
import com.pussydevdolls.covid.repositories.SintomaRepository
import com.pussydevdolls.covid.services.impl.SintomaServiceImpl
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

@ContextConfiguration(classes = [
    SintomaServiceImpl::class
])

@ExtendWith(SpringExtension::class)
class SintomaServiceImplTest {

    @Autowired
    lateinit var service: SintomaService

    @MockBean
    lateinit var repository: SintomaRepository

    @BeforeEach
    fun setUp() {
        val sintoma = Sintoma().apply {
            this.urlImagem = "url_imagem"
            this.nome = "Febre"
            this.id = 1L
        }

        Mockito.`when`(repository.findById(sintoma.id))
                .thenReturn(Optional.of(sintoma))

        Mockito.`when`(repository.findById(22L))
                .thenReturn(Optional.empty())
    }

    @Test
    fun `validate find by id`() {
        val found = service.findById(1)

        assertThat(found).isNotNull
    }

    @Test
    fun `validate find by invalid id throw NaoEncontradoException`() {
        Assertions.assertThrows(NaoEncontradoException::class.java) { service.findById(22L) }
    }
}