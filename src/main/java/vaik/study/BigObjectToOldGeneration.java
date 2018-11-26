package vaik.study;

public class BigObjectToOldGeneration {
    private static final int _1MB = 1024*1024;

    /**
     * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */

    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4*_1MB];
    }

    public static void main(String[] args) throws Throwable{
        testPretenureSizeThreshold();
    }
}
