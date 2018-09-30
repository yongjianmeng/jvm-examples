package com.yongjianmeng.stack;

public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    // -Xss128k
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

    /*
    stack length:983
    Exception in thread "main" java.lang.StackOverflowError
    at com.yongjianmeng.stack.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:8)
    at com.yongjianmeng.stack.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
    at com.yongjianmeng.stack.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
    at com.yongjianmeng.stack.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:9)
    ...
    */

    // 实验结果表明：无论是由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出的都是StackOverflowError异常
}
