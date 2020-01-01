package batch;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple5;

/**
 * @Auther fuxingnan
 * @Date 2020-01-01 13:37
 *
 * 读取csv文件，具体可以参考ppt
 */
public class ReadFromCSV {

    public static void main(String[] args) throws Exception {

        //准备环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //读取
        DataSet<Tuple5<Integer, Integer, String, String, String >> ds = env.readCsvFile("E:\\flink龙果ppt\\数据源\\user.csv")
                //需要提取的元素
                .includeFields("11111")
                //忽略特定的字符行
                .ignoreComments("##")
                //忽略首行
                .ignoreFirstLine()
                //忽略不合规的数据行
                .ignoreInvalidLines()
                //指定分隔符
                .lineDelimiter("\n")
                .fieldDelimiter(",")
                .types(Integer.class,Integer.class,String.class, String.class,String.class);

        ds.print();

    }
}
