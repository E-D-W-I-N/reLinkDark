package com.edwin.relink.controller

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class MessageReceiver {

    @RabbitListener(queues = ["PogChamp"])
    fun consumeMessageFromQueue(message: String) {
        println("Message received : $message")
    }
}