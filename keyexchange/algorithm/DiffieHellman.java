package com.keyexchange.algorithm;

import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    private BigInteger secretA;
    private BigInteger secretB;

    private BigInteger publicA;
    private BigInteger publicB;

    private BigInteger g;
    private BigInteger p;

    private BigInteger keyA;
    private BigInteger keyB;

    private int bitLength;

    SecureRandom secureRandom = new SecureRandom();

    public DiffieHellman(int bitLength) {
        this.bitLength = bitLength;

        p = new BigInteger(bitLength ^ 2, secureRandom);
        g = new BigInteger(8, secureRandom);
    }

    public void generate(){
        // first man
        secretA = new BigInteger(bitLength, secureRandom);
        publicA = g.modPow(secretA, p);
        //System.out.println("secretA = " + secretA);
        //System.out.println("publicA = " + publicA);

        //second man
        secretB = new BigInteger(bitLength, secureRandom);
        publicB = g.modPow(secretB, p);
        //System.out.println("secretB = " + secretB);
        //System.out.println("publicB = " + publicB);

        //exchange
        keyA = publicB.modPow(secretA, p);
        keyB = publicA.modPow(secretB, p);
        //System.out.println("\nkey A = " + keyA);
        //System.out.println("key B = " + keyB);
        //System.out.println("key size = " + keyA.bitLength());
    }

    public void check(){
        if(keyA.equals(keyB)){
            //System.out.println("Key A = Key B");
        } else{
            System.out.println("Key A != Key B");
        }
    }

    public BigInteger getSecretA() {
        return secretA;
    }

    public BigInteger getSecretB() {
        return secretB;
    }
}
