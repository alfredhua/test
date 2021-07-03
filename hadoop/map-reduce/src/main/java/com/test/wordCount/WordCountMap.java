package com.test.wordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMap extends Mapper<LongWritable, Text,Text, IntWritable> {

    private Text text=new Text();

    private IntWritable intWritabl=new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        final String s = value.toString();

        String[] words = s.split(" ");

        for (String word:words){
            text.set(word);
            context.write(text,intWritabl);
        }
    }
}
