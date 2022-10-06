package com.cuongnm.kafka.lab.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable {
    private String message;
    private String message1;
    private String message2;
    private String message3;
    private String message4;
}
