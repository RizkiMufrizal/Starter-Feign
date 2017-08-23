package org.rizki.mufrizal.starter.feign.restclient

import feign.Headers
import feign.Param
import feign.RequestLine
import org.rizki.mufrizal.starter.feign.domain.Credential

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 7:26 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.restclient
 * @File RequestOAuth2ServiceClient
 *
 */
interface RequestOAuth2ServiceClient {
    @RequestLine("POST /api/oauth/token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    fun authorization(@Param("grant_type") grantType: String, @Param("code") code: String, @Param("redirect_uri") redirectUri: String): Credential
}