# App Category Trends Analysis using MapReduce

## Project Overview

This project demonstrates the use of Apache Hadoop's MapReduce framework to analyze the popularity of app categories using the Google Play Store dataset. The goal is to count the number of apps available in each category and identify the most common types of applications on the Play Store.

---

## Dataset

- Source: [Google Play Store Apps Dataset](https://www.kaggle.com/datasets/lava18/google-play-store-apps)
- Format: CSV
- Size: ~100,000 records
- Fields Used: App, Category, Rating, Reviews, Installs

CSV file is named googleplaystore.csv and placed in local directory before uploading to HDFS.

---

## Technologies Used

- Apache Hadoop (Standalone Mode on WSL Ubuntu)
- Java (JDK 8 or above)
- HDFS (Hadoop Distributed File System)
- WSL 2 with Ubuntu (for local Hadoop setup)

---

## ⚙️ How to Run the Project

### Step 1: Clone the Repository

```bash
git clone https://github.com/DhananjiMadhushika/Analyzing_App_Categories_Hadoop_MapReduce
cd Analyzing_App_Categories_Hadoop_MapReduce/AppTrendsMR


```
### Step 2: Compile the Java Code

```bash
mkdir build
javac -classpath `hadoop classpath` -d build AppTrendsDriver.java CategoryCountMapper.java CategoryCountReducer.java

```

### Step 3: Create the JAR File

```bash
jar -cvf app-trends.jar -C build/ .

```
### Step 4: Upload Dataset to HDFS

```bash
# Copy the CSV file to Linux home
cp /mnt/c/Users/Subhanya/Downloads/googleplaystore.csv ~/

# Upload it to HDFS
hadoop fs -mkdir /input
hadoop fs -put ~/googleplaystore.csv /input/

```

### Step 5: Run the MapReduce Job

```bash
hadoop jar app-trends.jar AppTrendsDriver /input /output

```

### Step 6: View Results

```bash
hadoop fs -cat /output/part-r-00000

```

## References

* [kaggle - Google Play Store Apps Dataset](https://www.kaggle.com/datasets/lava18/google-play-store-apps)
* [Hadoop MapReduce Tutorial](https://hadoop.apache.org/docs/stable/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html)
