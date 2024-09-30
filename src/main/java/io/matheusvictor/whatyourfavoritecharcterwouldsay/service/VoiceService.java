package io.matheusvictor.whatyourfavoritecharcterwouldsay.service;

import io.matheusvictor.whatyourfavoritecharcterwouldsay.dto.SpeechDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "voice", url = "https://api.openai.com/v1/audio/speech")
public interface VoiceService {

    @GetMapping
    byte[] audio(@RequestHeader("Authorization") String token, @RequestBody SpeechDTO body);

}
