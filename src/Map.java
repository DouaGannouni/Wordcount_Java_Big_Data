
/**
 *
 * @author khlifi
 */
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

public class Map extends Mapper<Object,Text,Text,IntWritable>{
    //intwritebale convert oneto 1,two to 2 ...
    //setcombiner(gain au niv de temps d'execution(reduce de reduce celui celui (celui,2) au niv de lig1
   private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();
          protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                context.write(word, one);
            
        }
    }

}
