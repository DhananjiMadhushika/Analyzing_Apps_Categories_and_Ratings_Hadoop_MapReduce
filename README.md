# App Category Trends Analysis using MapReduce

## 📌 Project Overview

This project demonstrates the use of Apache Hadoop's MapReduce framework to analyze the popularity of app categories using the Google Play Store dataset. The goal is to count the number of apps available in each category and identify the most common types of applications on the Play Store.

---

## 📂 Dataset

- Source: [Google Play Store Apps Dataset](https://www.kaggle.com/datasets/lava18/google-play-store-apps)
- Format: CSV
- Size: ~100,000 records
- Fields Used: App, Category, Rating, Reviews, Installs

CSV file is named googleplaystore.csv and placed in local directory before uploading to HDFS.

---

## 🧰 Technologies Used

- Apache Hadoop (Standalone Mode on WSL Ubuntu)
- Java (JDK 8 or above)
- HDFS (Hadoop Distributed File System)
- WSL 2 with Ubuntu (for local Hadoop setup)

---

## ⚙️ How to Run the Project

### Step 1: Clone the Repository

```bash
git clone https://github.com/DhananjiMadhushika/App-Usage-Trends-and-Category-Popularity-using-MapReduce.git
cd App-Usage-Trends-and-Category-Popularity-using-MapReduce/AppTrendsMR
