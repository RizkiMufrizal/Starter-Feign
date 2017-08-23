package org.rizki.mufrizal.starter.feign.controller

import org.springframework.stereotype.Controller
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
class IndexController {

    @GetMapping(value = "/")
    fun index(): String = "index"

}