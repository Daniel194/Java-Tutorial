import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.sql.*;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.Tuple2;

import org.apache.spark.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.*;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.ml.linalg.VectorUDT;
import org.apache.spark.ml.stat.Correlation;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.functions.col;

/**
 * Command: /Users/daniellungu/Workspace/spark-2.2.1-bin-hadoop2.7/bin/spark-submit --class "SimpleApp" --master local[4] build/libs/spark-1.0-SNAPSHOT.jar
 */
public class SimpleApp {

    private static final String YOUR_SPARK_HOME = "/Users/daniellungu/Workspace/spark-2.2.1-bin-hadoop2.7/";
    private static final String SOURCE_JAR = "spark/build/libs/spark-1.0-SNAPSHOT.jar";
    private static final Integer NUM_SAMPLES = 1000000;
    private static final String FILE_PATH = "file:///Users/daniellungu/Workspace/Java-Tutorial/spark/src/main/resources/test.txt";

    public static void main(String[] args) {
        //firstExample();
        //wordCount();
        //piEstimation();
        //secondExample();
        //totalLength();
        //sparkStreaming();
        //dataFramesForJSON();
        correlation();
    }

    private static void firstExample() {
        String logFile = "/Users/daniellungu/Workspace/Java-Tutorial/spark/src/main/resources/test.txt";
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile).cache();

        long numAs = logData.filter(s -> s.contains("a")).count();
        long numBs = logData.filter(s -> s.contains("b")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        spark.stop();
    }

    private static void wordCount() {
        JavaSparkContext sc = new JavaSparkContext("local", "Simple App",
                YOUR_SPARK_HOME, new String[]{SOURCE_JAR});
        JavaRDD<String> textFile = sc.textFile(FILE_PATH);

        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);

        counts.saveAsTextFile("file:///Users/daniellungu/Workspace/Java-Tutorial/spark/src/main/resources/out");
    }

    private static void piEstimation() {
        JavaSparkContext sc = new JavaSparkContext("local", "Simple App",
                YOUR_SPARK_HOME, new String[]{SOURCE_JAR});

        List<Integer> l = new ArrayList<>(NUM_SAMPLES);

        for (int i = 0; i < NUM_SAMPLES; i++) {
            l.add(i);
        }

        long count = sc.parallelize(l).filter(i -> {
            double x = Math.random();
            double y = Math.random();
            return x * x + y * y < 1;
        }).count();

        System.out.println("Pi is roughly :" + 4.0 * count / NUM_SAMPLES);
    }

    private static void secondExample() {
        JavaSparkContext sc = new JavaSparkContext("local", "Simple App",
                YOUR_SPARK_HOME, new String[]{SOURCE_JAR});

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = sc.parallelize(data);

        int total = distData.reduce((a, b) -> a + b);

        System.out.println("Total : " + total);
    }

    private static void totalLength() {
        JavaSparkContext sc = new JavaSparkContext("local", "Simple App",
                YOUR_SPARK_HOME, new String[]{SOURCE_JAR});

        JavaRDD<String> lines = sc.textFile(FILE_PATH);
        JavaRDD<Integer> lineLengths = lines.map(s -> s.length());
        int totalLength = lineLengths.reduce((a, b) -> a + b);

        System.out.println("Total : " + totalLength);
    }

    private static void sparkStreaming() {
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));

        // Create a DStream that will connect to hostname:port, like localhost:9999
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9999);

        // Split each line into words
        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());

        // Count each word in each batch
        JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2<>(s, 1));
        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((i1, i2) -> i1 + i2);

        // Print the first ten elements of each RDD generated in this DStream to the console
        wordCounts.print();

        jssc.start(); // Start the computation
    }

    private static void dataFramesForJSON() {
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        Dataset<Row> df = spark.read().json("examples/src/main/resources/people.json");
        df.show();
        df.printSchema();
        df.select("name").show();
        df.select(col("name"), col("age").plus(1)).show();
        df.filter(col("age").gt(21)).show();
        df.groupBy("age").count().show();
    }

    private static void structuredStreaming() {
        SparkSession spark = SparkSession
                .builder()
                .appName("JavaStructuredNetworkWordCount")
                .getOrCreate();

        // Create DataFrame representing the stream of input lines from connection to localhost:9999
        Dataset<Row> lines = spark
                .readStream()
                .format("socket")
                .option("host", "localhost")
                .option("port", 9999)
                .load();

        // Split the lines into words
        Dataset<String> words = lines
                .as(Encoders.STRING())
                .flatMap((FlatMapFunction<String, String>) x -> Arrays.asList(x.split(" ")).iterator(), Encoders.STRING());

        // Generate running word count
        Dataset<Row> wordCounts = words.groupBy("value").count();

        // Start running the query that prints the running counts to the console
        StreamingQuery query = wordCounts.writeStream()
                .outputMode("complete")
                .format("console")
                .start();

    }


    private static void correlation() {
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config("spark.some.config.option", "some-value")
                .getOrCreate();

        List<Row> data = Arrays.asList(
                RowFactory.create(Vectors.sparse(4, new int[]{0, 3}, new double[]{1.0, -2.0})),
                RowFactory.create(Vectors.dense(4.0, 5.0, 0.0, 3.0)),
                RowFactory.create(Vectors.dense(6.0, 7.0, 0.0, 8.0)),
                RowFactory.create(Vectors.sparse(4, new int[]{0, 3}, new double[]{9.0, 1.0}))
        );

        StructType schema = new StructType(new StructField[]{
                new StructField("features", new VectorUDT(), false, Metadata.empty()),
        });

        Dataset<Row> df = spark.createDataFrame(data, schema);
        Row r1 = Correlation.corr(df, "features").head();
        System.out.println("Pearson correlation matrix:\n" + r1.get(0).toString());

        Row r2 = Correlation.corr(df, "features", "spearman").head();
        System.out.println("Spearman correlation matrix:\n" + r2.get(0).toString());
    }


}