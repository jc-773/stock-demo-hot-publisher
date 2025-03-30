package com.publish.stock_microservices.controller;

import org.springframework.web.bind.annotation.RestController;

import com.publish.stock_microservices.publisher.StockPriceImplementation;

import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StockFeedController {

    private StockPriceImplementation stockPriceService;

    @Autowired
    public StockFeedController(StockPriceImplementation stockPriceService) {
        this.stockPriceService = stockPriceService;
    }
    
    @GetMapping(value="/live/stock/feed/apple", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getAppleStockPrice() {
        return stockPriceService.emitApplePrice();
    }

    @GetMapping(value="/live/stock/feed/microsoft", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getMicrosoftStockPrice() {
        return stockPriceService.emitMicrosoftPrice();
    }

    @GetMapping(value="/live/stock/feed/tesla", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getTeslaStockPrice() {
        return stockPriceService.emitTeslaPrice();
    }
    
}
