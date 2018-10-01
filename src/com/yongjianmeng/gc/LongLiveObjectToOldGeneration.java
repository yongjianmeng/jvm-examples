package com.yongjianmeng.gc;

public class LongLiveObjectToOldGeneration {

    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
    }

//    -verbose:gc
//    -Xms20M
//    -Xmx20M
//    -Xmn10M
//    -XX:+PrintGCDetails
//    -XX:SurvivorRatio=8
//    -XX:+UseSerialGC
    public static void main(String[] args) {
        testTenuringThreshold();
    }


//    -XX:MaxTenuringThreshold=1
    /*
    [GC (Allocation Failure) [DefNew: 6531K->956K(9216K), 0.0058997 secs] 6531K->5052K(19456K), 0.0059675 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
    [GC (Allocation Failure) [DefNew: 5052K->0K(9216K), 0.0013176 secs] 9148K->5048K(19456K), 0.0013438 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [DefNew: 4096K->0K(9216K), 0.0426798 secs] 9144K->9144K(19456K), 0.0427174 secs] [Times: user=0.00 sys=0.00, real=0.04 secs]
    Heap
     def new generation   total 9216K, used 4262K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
      eden space 8192K,  52% used [0x00000000fec00000, 0x00000000ff029910, 0x00000000ff400000)
      from space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
      to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
     tenured generation   total 10240K, used 9144K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
       the space 10240K,  89% used [0x00000000ff600000, 0x00000000ffeee0f0, 0x00000000ffeee200, 0x0000000100000000)
     Metaspace       used 3435K, capacity 4496K, committed 4864K, reserved 1056768K
      class space    used 373K, capacity 388K, committed 512K, reserved 1048576K
     */

//    -XX:MaxTenuringThreshold=15
}
