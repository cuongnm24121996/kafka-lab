package com.cuongnm.kafka.lab.controller;

import com.cuongnm.kafka.lab.domain.MessageDTO;
import com.cuongnm.kafka.lab.producer.Producer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class NotifyController {

    private final Producer producer;

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MessageDTO dto) {
        log.info("Saving new message = {} into the topic", dto.toString());
        producer.sendMessage(dto);
    }
}
