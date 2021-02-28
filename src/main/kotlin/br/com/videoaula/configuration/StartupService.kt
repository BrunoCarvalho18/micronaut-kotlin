package br.com.videoaula.configuration

import br.com.videoaula.model.User
import br.com.videoaula.repository.UserRepository
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class StartupService(private val userRepository: UserRepository) {

    private val log = LoggerFactory.getLogger(StartupService::class.java)

    @EventListener
    fun onStartupEvent(event: StartupEvent){
        val user = userRepository.saveEncoded(User(
            191,
                "123456"
        ))
        log.info("Usuario adicionado: {}",user)
    }

}