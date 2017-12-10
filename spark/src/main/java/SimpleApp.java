import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

public class SimpleApp {
    public static void main(String[] args) {
        String logFile = "/Users/daniellungu/Workspace/Java-Tutorial/spark/src/main/resources/test.txt";
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile).cache();

        long numAs = logData.filter(s -> s.contains("a")).count();
        long numBs = logData.filter(s -> s.contains("b")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        spark.stop();
    }
}