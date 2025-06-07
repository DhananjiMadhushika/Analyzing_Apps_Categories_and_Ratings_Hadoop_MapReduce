import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageRatingReducer extends Reducer<Text, Text, Text, Text> {
    private Text result = new Text();

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        double sum = 0;
        int count = 0;

        for (Text val : values) {
            try {
                sum += Double.parseDouble(val.toString());
                count++;
            } catch (NumberFormatException e) {
                // Skip invalid values
            }
        }

        if (count > 0) {
            double average = sum / count;
            result.set(String.format("%.2f", average));
            context.write(key, result);
        }
    }
}