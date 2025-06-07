import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CategoryCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private final static LongWritable one = new LongWritable(1);
    private Text category = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // Skip header row
        if (key.get() == 0) return;

        String[] parts = value.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (parts.length >= 2) {
            String categoryStr = parts[1].trim();
            // Clean category name by removing quotes if present
            categoryStr = categoryStr.replaceAll("^\"|\"$", "");
            category.set(categoryStr);
            context.write(category, one);
        }
    }
}