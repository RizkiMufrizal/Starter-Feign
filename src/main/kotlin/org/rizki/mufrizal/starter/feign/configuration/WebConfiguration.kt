package org.rizki.mufrizal.starter.feign.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 8:08 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.configuration
 * @File WebConfiguration
 *
 */
@Configuration
class WebConfiguration : WebMvcConfigurerAdapter() {
    override fun addInterceptors(interceptorRegistry: InterceptorRegistry?) {
        interceptorRegistry?.addInterceptor(AuthenticationInterceptor())
    }
}