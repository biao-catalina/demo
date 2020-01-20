package com.example.algorithm.linked;

import lombok.Data;

@Data
public class Chain {
    private int value;

    private Chain next;

    public Chain(int value) {
        this.value = value;
    }

    public static void main(String[] args) {

        Chain next = null;
        for (int i = 8; i > 0; i--) {
            Chain chain = new Chain(i);
            if (next != null) {
                chain.setNext(next);
            }
            next = chain;
        }

        System.out.println(next);
    }

    private void splitByK(Chain chain, int k) {
        for (int i = 0; i < k; i++) {
            Chain next = chain.getNext();
            if (next != null) {
                chain.setNext(null);
                Chain temp = next.getNext();
                next.setNext(chain);
            }
        }
    }

}
