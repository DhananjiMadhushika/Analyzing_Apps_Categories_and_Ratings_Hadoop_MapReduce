import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class MostRatedMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        if (fields.length > 2 && !fields[2].equals("Rating")) {

                String appName = fields[0].trim();
                float rating = Float.parseFloat(fields[2].trim());
                context.write(new Text(appName), new FloatWritable(rating));

        }
    }
}
