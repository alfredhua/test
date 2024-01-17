package com.test.wordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * KEYIN,VALUEIN,KEYOUT,VALUEOUT
 */
public class WordCountReduce extends Reducer<Text,IntWritable ,Text, IntWritable> {

    private IntWritable outValue=new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int sum=0;
        for (IntWritable intWritable:values){
            sum=sum+intWritable.get();
        }
        outValue.set(sum);
        context.write(key,outValue);

    }
}
