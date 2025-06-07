import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class AverageRatingMapper extends Mapper<LongWritable, Text, Text, FloatWritable> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        if (fields.length > 2 && !fields[1].equals("Category")) {

                String category = fields[1].trim();
                float rating = Float.parseFloat(fields[2].trim());
                context.write(new Text(category), new FloatWritable(rating));

        }
    }
}
