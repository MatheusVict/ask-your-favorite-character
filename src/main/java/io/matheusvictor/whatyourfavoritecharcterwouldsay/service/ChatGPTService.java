package io.matheusvictor.whatyourfavoritecharcterwouldsay.service;

import io.matheusvictor.whatyourfavoritecharcterwouldsay.dto.AskDTO;

public interface ChatGPTService {
    byte[] sendMessage(AskDTO question);

}
