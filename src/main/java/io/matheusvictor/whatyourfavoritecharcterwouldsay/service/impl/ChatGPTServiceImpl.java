package io.matheusvictor.whatyourfavoritecharcterwouldsay.service.impl;

import io.matheusvictor.whatyourfavoritecharcterwouldsay.dto.SpeechDTO;
import io.matheusvictor.whatyourfavoritecharcterwouldsay.service.ChatGPTService;
import io.matheusvictor.whatyourfavoritecharcterwouldsay.service.VoiceService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {
    private final ChatClient chatClient;
    private final VoiceService voiceService;

    public ChatGPTServiceImpl(ChatClient.Builder chatClient, VoiceService voiceService) {
        this.chatClient = chatClient.build();
        this.voiceService = voiceService;
    }

    @Value("spring.ai.openai.api-key")
    String apiKey;

    @Override
    public byte[] sendMessage(String message) {
        String chatResponse = this.chatClient.prompt()
                .user(message)
                .call()
                .content();

        String header = " Bearer " + apiKey;
        SpeechDTO audioRequest = new SpeechDTO("tts-1", chatResponse, "alloy");
        return this.voiceService.audio(apiKey, audioRequest);

    }
}
