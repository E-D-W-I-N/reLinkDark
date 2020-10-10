package com.edwin.relink.repos

import com.edwin.relink.model.Link
import org.springframework.data.repository.Repository
import java.util.*

@org.springframework.stereotype.Repository
interface LinkRepository : Repository<Link, String> {
    fun findBySource(source: String?): Optional<Link>
    fun findByDestination(source: String?): Optional<Link>
    fun save(link: Link): Link

}