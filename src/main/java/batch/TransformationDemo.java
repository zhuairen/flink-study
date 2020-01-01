package batch;

import org.apache.flink.api.common.functions.MapPartitionFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @Auther fuxingnan
 * @Date 2020-01-01 14:13
 *
 * 转换 Map FlatMap MapPartition
 */
public class TransformationDemo {

    public static void main(String[] args) throws Exception {

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<Long> ds = env.generateSequence(1,20);

        //貌似会根据电脑线程数分配不同的分区
        ds.mapPartition(new MyMapPartition()).print();

    }

    public static class MyMapPartition implements MapPartitionFunction<Long,Long>{

        @Override
        public void mapPartition(Iterable<Long> iterable, Collector<Long> collector) throws Exception {
            long count = 0;
            for(Long value : iterable){
                count++;
            }
            collector.collect(count);
        }
    }
}
