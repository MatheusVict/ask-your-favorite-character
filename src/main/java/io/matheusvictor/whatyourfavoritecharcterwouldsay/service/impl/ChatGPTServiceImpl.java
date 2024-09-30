package io.matheusvictor.whatyourfavoritecharcterwouldsay.service.impl;

import io.matheusvictor.whatyourfavoritecharcterwouldsay.dto.AskDTO;
import io.matheusvictor.whatyourfavoritecharcterwouldsay.dto.SpeechDTO;
import io.matheusvictor.whatyourfavoritecharcterwouldsay.service.ChatGPTService;
import io.matheusvictor.whatyourfavoritecharcterwouldsay.service.VoiceService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
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
    public byte[] sendMessage(AskDTO question) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Me diga oque {character} diria sobre {theme} 
                """);
        promptTemplate.add("character", question.character());
        promptTemplate.add("theme", question.question());

        String chatResponse = this.chatClient.prompt(promptTemplate.create())
                .call()
                .content();

        String header = " Bearer " + apiKey;
        SpeechDTO audioRequest = new SpeechDTO("tts-1", chatResponse, "alloy");
        return this.voiceService.audio(header, audioRequest);

    }
}
