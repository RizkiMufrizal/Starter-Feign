package org.rizki.mufrizal.starter.feign.helpers

import feign.Feign
import feign.auth.BasicAuthRequestInterceptor
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 7:08 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.helpers
 * @File FeignHelper
 *
 */

class FeignHelper {
    companion object {
        fun <T> feignBuilder(clz: Class<T>): T = Feign.builder().encoder(JacksonEncoder()).decoder(JacksonDecoder()).target(clz, "https://api-753:8065")
        fun <T> feignBuilderOAuth2Authentication(clz: Class<T>, clientId: String, clientSecret: String): T = Feign.builder().encoder(JacksonEncoder()).decoder(JacksonDecoder()).requestInterceptor(BasicAuthRequestInterceptor(clientId, clientSecret)).target(clz, "https://api-753:8089")
    }
}