package org.rizki.mufrizal.starter.feign.controller

import org.rizki.mufrizal.starter.feign.helpers.FeignHelper
import org.rizki.mufrizal.starter.feign.restclient.TransactionServiceClient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.stereotype.Controller
import javax.servlet.http.HttpSession


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 8:04 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.controller
 * @File TransactionController
 *
 */
@Controller
class TransactionController {

    @GetMapping(value = "/transaction")
    fun getTransactions(httpSession: HttpSession, model: Model): String {
        val map = HashMap<String, Any>()
        map.put("Authorization", "Bearer ${httpSession.getAttribute("access_token")}")
        val content = FeignHelper.feignBuilder(TransactionServiceClient::class.java).getTransactions(map)
        model.addAttribute("transactions", content.content)
        return "transaction"
    }
}
