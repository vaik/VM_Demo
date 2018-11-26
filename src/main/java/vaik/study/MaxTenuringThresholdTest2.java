package vaik.study;

public class MaxTenuringThresholdTest2 {

    private static final int _1MB = 1024*1024;

    /**
     * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     */

    @SuppressWarnings("unused")
    public static void testTenuringThershold2(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[_1MB/4];
        //什么时候进入老年代取决于 XX:MaxTenuringThreshold设置
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }


    public static void main(String[] args) throws Throwable{
        testTenuringThershold2();
    }
}
