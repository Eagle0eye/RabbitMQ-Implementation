package com.eagle0eye.rabbitmq_demo.infrastructure.rabbitmq.adapter;

import com.eagle0eye.rabbitmq_demo.core.rabbitmq.appliction.RabbitmqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rabbitmq")
public class RabbitmqController {

    private final RabbitmqService mRabbitService;

    @PostMapping("/create")
    public ResponseEntity<String> postMessage(@RequestBody String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mRabbitService.create(message));
    }
}
