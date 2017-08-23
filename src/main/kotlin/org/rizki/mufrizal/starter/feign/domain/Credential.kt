package org.rizki.mufrizal.starter.feign.domain


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 7:46 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.domain
 * @File Credential
 *
 */
data class Credential(val access_token: String? = null, val refresh_token: String? = null)