package com.yongjianmeng.stack;

// Windows机器谨慎运行该代码
public class JavaVMStackOOM {

    private void dontStop() {
        while(true) {
        }
    }

    public void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
