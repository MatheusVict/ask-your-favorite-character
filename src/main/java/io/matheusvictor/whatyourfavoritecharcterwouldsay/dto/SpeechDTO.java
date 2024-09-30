package io.matheusvictor.whatyourfavoritecharcterwouldsay.dto;

public record SpeechDTO(
        String model,
        String input,
        String voice
        ) {
}
