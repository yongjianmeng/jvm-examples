package com.yongjianmeng.methodarea;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {

    // JDK <= 1.6
    // -XX:PermSize=10M -XX:MaxPermSize=10M
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while(true) {
//            // String.intern() 是一个Native方法，它的作用是：如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个
//            // 字符串的String对象，否则，将此String对象包含的字符串添加到常量池中，并返回此String对象的引用。
//            list.add(String.valueOf(i++).intern());
//        }
//    }

    // JDK <= 1.6 false false
    // JDK > 1.6 true false
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    // 在JDK 1.6中，intern方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串实例的引用，而由StringBuilder
    // 创建的字符串实例在Java堆上，所以必然不是同一个引用，将返回false
    // 在JDK 1.7中，intern的实现不会再复制实例，只是在常量池中记录首次出现的实例引用，因此intern返回的引用和由StringBuilder创建
    // 的那个字符串实例是同一个。对str2返回false是因为“java”这个字符在执行StringBuilder.toString之前已经出现过，
    // 字符串常量池中已经有它的引用了，不符合“首次出现”的原则，而“计算机软件”这个字符串是首次出现，因此返回true。

}
