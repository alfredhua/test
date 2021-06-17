package com.map.test;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

         Job instance = Job.getInstance();

         instance.setJarByClass(WordCountMain.class);

         instance.setMapperClass(WordCountMap.class);
         instance.setReducerClass(WordCountReduce.class);


         instance.setMapOutputValueClass(IntWritable.class);
         instance.setMapOutputKeyClass(Text.class);

         instance.setOutputKeyClass(Text.class);
         instance.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(instance,"/Users/guozhenhua7/temp/input/wordCount.txt");
        FileOutputFormat.setOutputPath(instance,new Path("/Users/guozhenhua7/temp/output/wordCount"));
        instance.waitForCompletion(false);

    }
}
