package org.rizki.mufrizal.starter.feign

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class StarterFeignApplication

fun main(args: Array<String>) {
    SpringApplication.run(StarterFeignApplication::class.java, *args)
}
