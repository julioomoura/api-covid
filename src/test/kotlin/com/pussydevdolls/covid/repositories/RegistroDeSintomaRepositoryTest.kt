package com.pussydevdolls.covid.repositories

import com.pussydevdolls.covid.models.RegistroDeSintoma
import com.pussydevdolls.covid.models.Sintoma
import com.pussydevdolls.covid.models.Usuario
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDate

@DataJpaTest
class RegistroDeSintomaRepositoryTest {

    @Autowired
    private lateinit var repository: RegistroDeSintomaRepository

    private fun factoryRegistroDeSintoma(): RegistroDeSintoma {
        return RegistroDeSintoma().apply {
            this.data = LocalDate.now()
            this.nivel = 0
            this.usuario = Usuario("12345678910")
            this.sintoma = Sintoma().apply{ this.nome = "Febre" }
        }
    }
}