package org.rizki.mufrizal.starter.feign.controller

import feign.FeignException
import org.rizki.mufrizal.starter.feign.helpers.FeignHelper
import org.rizki.mufrizal.starter.feign.restclient.RequestOAuth2ServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpSession

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 7:38 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.controller
 * @File RequestOAuth2Controller
 *
 */

@Controller
class RequestOAuth2Controller @Autowired constructor(val environment: Environment) {

    @GetMapping(value = "/authorization")
    fun getAuthCode(@RequestParam("code", required = true) code: String, httpSession: HttpSession): String {
        val credential = FeignHelper.feignBuilderOAuth2Authentication(RequestOAuth2ServiceClient::class.java, clientId = environment.getRequiredProperty("axway_oauth2.client_id"), clientSecret = environment.getRequiredProperty("axway_oauth2.client_secret")).authorization(
                    grantType = environment.getRequiredProperty("axway_oauth2.grant_type"),
                    redirectUri = environment.getRequiredProperty("axway_oauth2.redirect_uri"),
                    code = code)
            print(credential.access_token)
            httpSession.setAttribute("UserSession", true)
            httpSession.setAttribute("access_token", credential.access_token)
            httpSession.setAttribute("refresh_token", credential.refresh_token)
            return "redirect:/transaction"
    }

}
