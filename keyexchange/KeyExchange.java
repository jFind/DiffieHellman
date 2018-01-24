package com.keyexchange;

import com.keyexchange.algorithm.DiffieHellman;

import java.util.Date;

public class KeyExchange {

    private static final int bitLength = 4096;
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("new loop");
            Date date1 = new Date();
            for (int j = 0; j < 100; j++) {
                DiffieHellman diffieHellman = new DiffieHellman(bitLength);
                diffieHellman.generate();
                diffieHellman.check();
            }
            Date date2 = new Date();
            System.out.println("sec:" +  (date2.getTime() - date1.getTime()) / 1000);
        }
    }
}
