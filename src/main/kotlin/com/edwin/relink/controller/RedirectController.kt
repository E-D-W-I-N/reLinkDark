package com.edwin.relink.controller

import com.edwin.relink.serice.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

@Controller
class RedirectController {

    @Autowired
    lateinit var service: KeyMapperService

    @RequestMapping("/add/{key}/{link}")
    fun add(@PathVariable("key") key: String, @PathVariable("link") link: String, response: HttpServletResponse) {
        when (service.add(key, link)) {
            is KeyMapperService.Add.Success -> response.status = 200
            is KeyMapperService.Add.AlreadyExist -> response.status = 302
        }
    }

    @RequestMapping("/get/{key}")
    fun redirect(@PathVariable("key") key: String, response: HttpServletResponse) {
        when (val result = service.getLink(key)) {
            is KeyMapperService.Get.Link -> {
                response.setHeader(HEADER_NAME, result.link)
                response.status = 302
            }
            is KeyMapperService.Get.NotFound -> response.status = 404
        }
    }

    companion object {
        private const val HEADER_NAME = "Location"
    }
}