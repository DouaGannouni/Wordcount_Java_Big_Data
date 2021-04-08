import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;


       public  class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable value = new IntWritable(0);
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable value : values)
                sum += value.get();
            value.set(sum);
            context.write(key, value);
        }
    }

