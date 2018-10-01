package com.yongjianmeng.gc;

public class NewGenerationMinorGC {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[3 * _1MB];
    }

//    -verbose:gc
//    -Xms20M
//    -Xmx20M
//    -Xmn10M
//    -XX:+PrintGCDetails
//    -XX:SurvivorRatio=8
//    -XX:+UseSerialGC
    public static void main(String[] args) {
        testAllocation();
    }

    /*
    [GC (Allocation Failure) [DefNew: 6275K->700K(9216K), 0.0080140 secs] 6275K->4796K(19456K), 0.0080647 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
    Heap
     def new generation   total 9216K, used 7165K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
      eden space 8192K,  78% used [0x00000000fec00000, 0x00000000ff250638, 0x00000000ff400000)
      from space 1024K,  68% used [0x00000000ff500000, 0x00000000ff5af120, 0x00000000ff600000)
      to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
     tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
       the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00020, 0x00000000ffa00200, 0x0000000100000000)
     Metaspace       used 3436K, capacity 4496K, committed 4864K, reserved 1056768K
      class space    used 373K, capacity 388K, committed 512K, reserved 1048576K
     */

}
