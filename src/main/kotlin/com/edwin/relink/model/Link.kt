package com.edwin.relink.model

import javax.persistence.*

@Entity
@Table
data class Link(
        var source: String = "",
        var destination: String = "",

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0
)