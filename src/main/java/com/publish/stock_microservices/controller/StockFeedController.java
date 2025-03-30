package com.publish.stock_microservices.controller;

import org.springframework.web.bind.annotation.RestController;

import com.publish.stock_microservices.publisher.StockPriceImplementation;

import reactor.core.publisher.Flux;

import java.util.Map;

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
    public Flux<String> getAppleStockPrice() {
        return stockPriceService.emitApplePrice().share();
    }

    @GetMapping(value="/live/stock/feed/microsoft", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getMicrosoftStockPrice() {
        return stockPriceService.emitMicrosoftPrice().share();
    }

    @GetMapping(value="/live/stock/feed/tesla", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getTeslaStockPrice() {
        return stockPriceService.emitTeslaPrice().share();
    }
    
}
