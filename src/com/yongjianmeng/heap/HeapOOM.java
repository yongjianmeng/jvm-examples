package com.yongjianmeng.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {

    }

    // -verbose:gc
    // -Xms20M
    // -Xmx20M
    // -Xmn10M
    // -XX:+PrintGCDetails
    // -XX:SurvivorRatio=8
    // -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while(true) {
            list.add(new OOMObject());
        }
    }

    /*
    [GC (Allocation Failure) [PSYoungGen: 8192K->1000K(9216K)] 8192K->4889K(19456K), 0.0073044 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
            [GC (Allocation Failure) --[PSYoungGen: 9192K->9192K(9216K)] 13081K->19424K(19456K), 0.0127315 secs] [Times: user=0.08 sys=0.02, real=0.01 secs]
            [Full GC (Ergonomics) [PSYoungGen: 9192K->0K(9216K)] [ParOldGen: 10232K->10157K(10240K)] 19424K->10157K(19456K), [Metaspace: 3440K->3440K(1056768K)], 0.1900536 secs] [Times: user=0.48 sys=0.02, real=0.19 secs]
            [Full GC (Ergonomics) [PSYoungGen: 8192K->8151K(9216K)] [ParOldGen: 10157K->8395K(10240K)] 18349K->16546K(19456K), [Metaspace: 3440K->3440K(1056768K)], 0.1921330 secs] [Times: user=0.50 sys=0.05, real=0.19 secs]
            [Full GC (Ergonomics) [PSYoungGen: 8192K->8152K(9216K)] [ParOldGen: 8395K->8395K(10240K)] 16587K->16547K(19456K), [Metaspace: 3440K->3440K(1056768K)], 0.1053106 secs] [Times: user=0.53 sys=0.00, real=0.11 secs]
            [Full GC (Allocation Failure) [PSYoungGen: 8152K->8140K(9216K)] [ParOldGen: 8395K->8388K(10240K)] 16547K->16528K(19456K), [Metaspace: 3440K->3440K(1056768K)], 0.1132889 secs] [Times: user=0.61 sys=0.00, real=0.11 secs]
    java.lang.OutOfMemoryError: Java heap space
    Dumping heap to java_pid7976.hprof ...
    Heap dump file created [28342143 bytes in 0.149 secs]
            [Full GC (Ergonomics) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at java.util.Arrays.copyOf(Arrays.java:3210)
    at java.util.Arrays.copyOf(Arrays.java:3181)
    at java.util.ArrayList.grow(ArrayList.java:265)
    at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
    at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
    at java.util.ArrayList.add(ArrayList.java:462)
    at com.yongjianmeng.heap.HeapOOM.main(HeapOOM.java:23)
            [PSYoungGen: 8192K->0K(9216K)] [ParOldGen: 8388K->701K(10240K)] 16580K->701K(19456K), [Metaspace: 3466K->3466K(1056768K)], 0.0047138 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
    Heap
    PSYoungGen      total 9216K, used 82K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
    eden space 8192K, 1% used [0x00000000ff600000,0x00000000ff614938,0x00000000ffe00000)
    from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
    to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
    ParOldGen       total 10240K, used 701K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
    object space 10240K, 6% used [0x00000000fec00000,0x00000000fecaf798,0x00000000ff600000)
    Metaspace       used 3472K, capacity 4500K, committed 4864K, reserved 1056768K
    class space    used 377K, capacity 388K, committed 512K, reserved 1048576K
    */
}
