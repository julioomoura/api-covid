package com.pussydevdolls.covid.repositories

import com.pussydevdolls.covid.models.Sintoma
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class SintomaRepositoryTest {

    @Autowired
    private lateinit var sintomaRepository: SintomaRepository

    @Test
    fun `validate find by name` () {
        sintomaRepository.save(Sintoma().apply { this.nome = "Dor de cabeça" })

        val found = sintomaRepository.findByNome("Dor de cabeça")

        assertThat(found).isPresent
        assertThat(found.get().nome).isEqualTo("Dor de cabeça")
    }
}