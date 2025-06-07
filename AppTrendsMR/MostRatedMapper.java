import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MostRatedMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private Text appName = new Text();
    private LongWritable reviews = new LongWritable();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // Skip header row
        if (key.get() == 0) return;

        String[] parts = value.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (parts.length >= 4) {
            String name = parts[0].trim().replaceAll("^\"|\"$", "");
            String reviewsStr = parts[3].trim();

            try {
                long reviewCount = Long.parseLong(reviewsStr);
                appName.set(name);
                reviews.set(reviewCount);
                context.write(appName, reviews);
            } catch (NumberFormatException e) {
                // Skip invalid review counts
            }
        }
    }
}