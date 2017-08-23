package org.rizki.mufrizal.starter.feign.controller

import org.rizki.mufrizal.starter.feign.helpers.FeignHelper
import org.rizki.mufrizal.starter.feign.restclient.TransactionServiceClient
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
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
@RestController
class TransactionController {

    @GetMapping(value = "/transaction")
    fun getTransactions(httpSession: HttpSession): ResponseEntity<*> = ResponseEntity(FeignHelper.feignBuilder(TransactionServiceClient::class.java).getTransactions(httpSession.getAttribute("access_token").toString()), HttpStatus.OK)
}