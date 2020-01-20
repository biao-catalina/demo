package com.java;

import java.time.LocalDateTime;

public class BiaoThread {

/*    static {
        System.loadLibrary("BiaoThreadNative");
    }*/

//    private native void start0();

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    private void run() {

    }

}
