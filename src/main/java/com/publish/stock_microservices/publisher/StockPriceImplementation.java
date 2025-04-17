package com.publish.stock_microservices.publisher;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.publish.stock_microservices.Utils;

import reactor.core.publisher.Flux;

@Service
public class StockPriceImplementation implements StockPriceService {


    @Override
    public Flux<Integer> emitApplePrice() {
      return Flux.generate(syncSink -> {
            var randomPrice = Utils.faker().random().nextInt(65, 120);
            syncSink.next(randomPrice);
      })
      .delayElements(Duration.ofSeconds(5))
      .cast(Integer.class);
    }

    @Override
    public Flux<Integer> emitMicrosoftPrice() {
        return Flux.generate(syncSink -> {
            var randomPrice = Utils.faker().random().nextInt(115, 220);
            syncSink.next(randomPrice);
      })
      .delayElements(Duration.ofSeconds(5))
      .cast(Integer.class);
    }

    @Override
    public Flux<Integer> emitTeslaPrice() {
        return Flux.generate(syncSink -> {
            var randomPrice = Utils.faker().random().nextInt(265, 520);
            syncSink.next(randomPrice);
      })
      .delayElements(Duration.ofSeconds(5))
      .cast(Integer.class);
    }
    
}
