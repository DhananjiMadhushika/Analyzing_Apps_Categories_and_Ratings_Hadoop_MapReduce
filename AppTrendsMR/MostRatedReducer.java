import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MostRatedReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    private float maxRating = 0;
    private Text mostRatedApp = new Text();

    public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        for (FloatWritable val : values) {
            float rating = val.get();
            if (rating > maxRating) {
                maxRating = rating;
                mostRatedApp.set(key);
            }
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        context.write(mostRatedApp, new FloatWritable(maxRating));
    }
}
