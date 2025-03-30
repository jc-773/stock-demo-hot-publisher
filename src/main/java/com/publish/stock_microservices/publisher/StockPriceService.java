package com.publish.stock_microservices.publisher;

import reactor.core.publisher.Flux;

public interface StockPriceService {
    Flux<String> emitApplePrice();
    Flux<String> emitMicrosoftPrice();
    Flux<String> emitTeslaPrice();
}
