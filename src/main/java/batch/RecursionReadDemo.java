package batch;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.configuration.Configuration;

/**
 * @Auther fuxingnan
 * @Date 2020-01-01 13:57
 *
 * 地柜读取文件夹中的文件
 */
public class RecursionReadDemo {

    public static void main(String[] args) throws Exception {

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        //设置递归参数
        Configuration con = new Configuration();

        //真难记
        con.setBoolean("recursive.file.enumeration",true);

        DataSet<String> ds = env.readTextFile("E:\\flink龙果ppt\\数据源").withParameters(con);

        ds.print();
    }
}
