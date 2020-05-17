package com.pussydevdolls.covid.services

import com.pussydevdolls.covid.repositories.RegistroDeSintomaRepository
import com.pussydevdolls.covid.services.impl.RegistroDeSintomaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [
    RegistroDeSintomaServiceImpl::class
])
class RegistroDeSintomaServiceImplTest {

    @Autowired
    private lateinit var service: RegistroDeSintomaService

    @MockBean
    private lateinit var repository: RegistroDeSintomaRepository

}