package io.matheusvictor.whatyourfavoritecharcterwouldsay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class whatYourFavoriteCharcterWouldSayApplication {

    public static void main(String[] args) {
        SpringApplication.run(whatYourFavoriteCharcterWouldSayApplication.class, args);
    }

}

