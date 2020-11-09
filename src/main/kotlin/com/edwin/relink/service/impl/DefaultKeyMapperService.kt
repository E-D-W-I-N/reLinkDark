package com.edwin.relink.service.impl

import com.edwin.relink.model.Link
import com.edwin.relink.repos.LinkRepository
import com.edwin.relink.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class DefaultKeyMapperService : KeyMapperService {

    @Autowired
    lateinit var repo: LinkRepository

    @Transactional
    override fun add(link: String): String {
        val charPool = "1234567890".toCharArray()
        val randomString = (1..7)
                .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")
        repo.save(Link(randomString, link))
        return randomString
    }

    override fun getLink(key: String): KeyMapperService.Get {
        val result = repo.findBySource(key)
        return if (result.isPresent) {
            KeyMapperService.Get.Link(result.get().destination)
        } else {
            KeyMapperService.Get.NotFound(key)
        }
    }

}