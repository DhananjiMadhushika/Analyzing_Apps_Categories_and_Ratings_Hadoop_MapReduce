import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AverageRatingMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text category = new Text();
    private Text rating = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // Skip header row
        if (key.get() == 0) return;

        String[] parts = value.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (parts.length >= 3) {
            String categoryStr = parts[1].trim().replaceAll("^\"|\"$", "");
            String ratingStr = parts[2].trim();

            try {
                // Only process if rating is valid
                Double.parseDouble(ratingStr);
                category.set(categoryStr);
                rating.set(ratingStr);
                context.write(category, rating);
            } catch (NumberFormatException e) {
                // Skip invalid ratings
            }
        }
    }
}