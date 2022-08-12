package com.flink.connect;

import com.flink.connect.entity.RideAndFare;
import com.flink.connect.entity.TaxiFare;
import com.flink.connect.entity.TaxiRide;
import com.flink.connect.sources.TaxiFareGenerator;
import com.flink.connect.sources.TaxiRideGenerator;
import com.flink.connect.utils.MissingSolutionException;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.RichCoFlatMapFunction;
import org.apache.flink.streaming.api.functions.sink.PrintSinkFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.util.Collector;

import java.util.concurrent.TimeUnit;

public class RidesAndFaresExercise {

    private final SourceFunction<TaxiRide> rideSource;
    private final SourceFunction<TaxiFare> fareSource;
    private final SinkFunction<RideAndFare> sink;

    /** Creates a job using the sources and sink provided. */
    public RidesAndFaresExercise(
            SourceFunction<TaxiRide> rideSource,
            SourceFunction<TaxiFare> fareSource,
            SinkFunction<RideAndFare> sink) {
        this.rideSource = rideSource;
        this.fareSource = fareSource;
        this.sink = sink;
    }

    public static void main(String[] args) throws Exception {
        RidesAndFaresExercise job =
                new RidesAndFaresExercise(
                        new TaxiRideGenerator(),
                        new TaxiFareGenerator(),
                        new PrintSinkFunction<>());

        job.execute();
    }

    public void execute() throws Exception{
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        executionEnvironment.setRestartStrategy(RestartStrategies.failureRateRestart(
                3, // 一个时间段内的最大失败次数
                Time.of(5, TimeUnit.MINUTES), // 衡量失败次数的是时间段
                Time.of(10, TimeUnit.SECONDS) // 间隔
        ));
        DataStream<TaxiRide> rideSourceDataStream = executionEnvironment.addSource(rideSource).name("rideSource");
        DataStream<TaxiRide> rides  = rideSourceDataStream.filter(ride -> ride.isStart).keyBy(ride -> ride.rideId);


        DataStream<TaxiFare> fareDataStream = executionEnvironment.addSource(fareSource).name("fareSource");
        DataStream<TaxiFare> fares  = fareDataStream.keyBy(fare->fare.rideId);
        rides.connect(fares).flatMap(new EnrichmentFunction()).addSink(sink);

        executionEnvironment.execute();
    }

    public static class EnrichmentFunction extends RichCoFlatMapFunction<TaxiRide,TaxiFare,RideAndFare>{

        @Override
        public void flatMap1(TaxiRide value, Collector<RideAndFare> out) throws Exception {
            throw new MissingSolutionException();
        }

        @Override
        public void flatMap2(TaxiFare value, Collector<RideAndFare> out) throws Exception {
            throw new MissingSolutionException();
        }
    }
}
