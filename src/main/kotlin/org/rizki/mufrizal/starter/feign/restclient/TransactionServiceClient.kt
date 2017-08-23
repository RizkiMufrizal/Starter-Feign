package org.rizki.mufrizal.starter.feign.restclient

import feign.Headers
import feign.RequestLine
import org.rizki.mufrizal.starter.feign.domain.Content
import org.springframework.web.bind.annotation.RequestHeader


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 8:02 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.restclient
 * @File TransactionServiceClient
 *
 */
interface TransactionServiceClient {
    @RequestLine("GET /v7/transactions")
    @Headers("Content-Type: application/json")
    fun getTransactions(@RequestHeader("Authorization") token: String): Content
}