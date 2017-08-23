package org.rizki.mufrizal.starter.feign.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 8:17 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.controller
 * @File IndexController
 *
 */
@Controller
class IndexController @Autowired constructor(val environment: Environment) {

    @GetMapping(value = "/")
    fun index(model: Model): String {
        val clientId = environment.getRequiredProperty("axway_oauth2.client_id")
        val responseType = environment.getRequiredProperty("axway_oauth2.response_type")
        val redirectUri = environment.getRequiredProperty("axway_oauth2.redirect_uri")
        val scope = environment.getRequiredProperty("axway_oauth2.scope")
        val urlAuthorize = environment.getRequiredProperty("axway_oauth2.url_authorize")
        val urlAuthentication = "$urlAuthorize?client_id=$clientId&response_type=$responseType&scope=$scope&redirect_uri=$redirectUri"
        model.addAttribute("url", urlAuthentication)
        return "index"
    }

}