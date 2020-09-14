package com.java;

public class BiaoThread {

/*    static {
        System.loadLibrary("BiaoThreadNative");
    }*/

//    private native void start0();

    public static void main(String[] args) {
        BiaoThread t = new BiaoThread();
        String s = "aaa";
        t.run(s);
        System.out.println(s);
    }

    private void run(String s) {
        s = s.replace("a", "b");
    }

}
