package com.flink.demo.stock;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockSource implements SourceFunction<StockPrice> {

    private boolean running;

    private String path;

    private InputStream streamSource;

    public StockSource(String path) {
        this.path = path;
    }

    @Override
    public void run(SourceContext<StockPrice> ctx) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
        streamSource = this.getClass().getClassLoader().getResourceAsStream(path);
        BufferedReader bf = new BufferedReader(new InputStreamReader(streamSource));
        String line;
        while (running && (line=bf.readLine())!=null){
            String[] split = line.split(",");
            LocalDateTime parse = LocalDateTime.parse(split[1] + " " + split[2], formatter);
            StockPrice stockPrice = new StockPrice();
            stockPrice.setCode(split[0]);
            stockPrice.setDateTime(parse);
            stockPrice.setPrice(Double.parseDouble(split[3]));
            stockPrice.setCount(Integer.parseInt(split[4]));
            ctx.collect(stockPrice);
        }
    }

    @Override
    public void cancel() {
        try {
            streamSource.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        running = false;
    }
}
