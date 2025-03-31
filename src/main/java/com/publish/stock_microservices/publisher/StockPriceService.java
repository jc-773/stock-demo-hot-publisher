package com.publish.stock_microservices.publisher;

import reactor.core.publisher.Flux;

public interface StockPriceService {
    Flux<Integer> emitApplePrice();
    Flux<Integer> emitMicrosoftPrice();
    Flux<Integer> emitTeslaPrice();
}
