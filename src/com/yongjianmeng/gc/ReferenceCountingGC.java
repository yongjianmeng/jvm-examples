package com.yongjianmeng.gc;

public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }

    /*
    [GC (System.gc())  7433K->880K(125952K), 0.0008118 secs]
    [Full GC (System.gc())  880K->696K(125952K), 0.0049114 secs]
    */

    // 说明虚拟机并不是通过引用技术算法来判断对象是否存活的

}
