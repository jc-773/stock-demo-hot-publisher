package com.publish.stock_microservices.publisher;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.publish.stock_microservices.Utils;

import reactor.core.publisher.Flux;

@Service
public class StockPriceImplementation implements StockPriceService {

    @Override
    public Flux<String> emitApplePrice() {
      return Flux.generate(syncSink -> {
            var randomPrice = Utils.faker().random().nextInt(65, 120);
            syncSink.next("Apple: " + randomPrice);
      })
      .delayElements(Duration.ofSeconds(10))
      .cast(String.class);
    }

    @Override
    public Flux<String> emitMicrosoftPrice() {
        return Flux.generate(syncSink -> {
            var randomPrice = Utils.faker().random().nextInt(115, 220);
            syncSink.next("Microsoft: " + randomPrice);
      })
      .delayElements(Duration.ofSeconds(10))
      .cast(String.class);
    }

    @Override
    public Flux<String> emitTeslaPrice() {
        return Flux.generate(syncSink -> {
            var randomPrice = Utils.faker().random().nextInt(265, 520);
            syncSink.next("Tesla: " + randomPrice);
      })
      .delayElements(Duration.ofSeconds(10))
      .cast(String.class);
    }
    
}
