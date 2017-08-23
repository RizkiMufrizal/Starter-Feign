package org.rizki.mufrizal.starter.feign.domain

import java.math.BigDecimal
import java.util.*


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 7:59 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.domain
 * @File Transaction
 *
 */
data class Transaction(
        val transactionId: String? = null,
        val transactionDate: Date? = null,
        val transactionPrice: BigDecimal? = null,
        val transactionCount: Int? = null,
        val transactionTotal: BigDecimal? = null
)