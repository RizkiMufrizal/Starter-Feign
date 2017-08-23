package org.rizki.mufrizal.starter.feign.configuration

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 23 August 2017
 * @Time 8:07 PM
 * @Project Starter-Feign
 * @Package org.rizki.mufrizal.starter.feign.configuration
 * @File AuthenticationInterceptor
 *
 */
class AuthenticationInterceptor : HandlerInterceptorAdapter() {

    @Throws(Exception::class)
    override fun preHandle(httpServletRequest: HttpServletRequest?, httpServletResponse: HttpServletResponse?, handler: Any?): Boolean {
        val httpSession: HttpSession? = httpServletRequest?.getSession(true)
        val requestMapping = (handler as HandlerMethod).getMethodAnnotation(RequestMapping::class.java)
        val loginPageRequest = requestMapping != null && requestMapping.value.isNotEmpty() && requestMapping.path.contains("/login")

        if (httpSession?.getAttribute("UserSession") == null && !loginPageRequest) {
            httpServletResponse?.sendRedirect("${httpServletRequest?.contextPath}/login")
            return false
        }
        return true
    }
}