package io.matheusvictor.whatyourfavoritecharcterwouldsay.controller;

import io.matheusvictor.whatyourfavoritecharcterwouldsay.dto.AskDTO;
import io.matheusvictor.whatyourfavoritecharcterwouldsay.service.ChatGPTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ask")
@RequiredArgsConstructor
@Log4j2
public class Controller {
    private final ChatGPTService chatGPTService;

    @GetMapping
    byte[] askToGPT(@RequestBody AskDTO message) {
        return this.chatGPTService.sendMessage(message);

    }
}
