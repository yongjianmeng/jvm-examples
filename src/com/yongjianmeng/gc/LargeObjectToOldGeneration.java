package com.yongjianmeng.gc;

public class LargeObjectToOldGeneration {
    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

//    -XX:PretenureSizeThreshold=3145728
//    -verbose:gc
//    -Xms20M
//    -Xmx20M
//    -Xmn10M
//    -XX:+PrintGCDetails
//    -XX:SurvivorRatio=8
//    -XX:+UseSerialGC
    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    /*
    Heap
     def new generation   total 9216K, used 2343K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
      eden space 8192K,  28% used [0x00000000fec00000, 0x00000000fee49d78, 0x00000000ff400000)
      from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
      to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
     tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
       the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
     Metaspace       used 3415K, capacity 4496K, committed 4864K, reserved 1056768K
      class space    used 369K, capacity 388K, committed 512K, reserved 1048576K
     */
}
