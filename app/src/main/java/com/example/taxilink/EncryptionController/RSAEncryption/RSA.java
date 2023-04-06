package com.example.taxilink.EncryptionController.RSAEncryption;

import com.example.taxilink.EncryptionController.DataEncryption;

import java.util.concurrent.ThreadLocalRandom;

public class RSA implements DataEncryption {
    private long prvKey;
    private long pubKey;
    private long n;
    private final long[] primes = {101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1021};

    public RSA() {
        generateKeys();
    }


    @Override
    public String encrypt(String data) {
        StringBuilder enMessage = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            long encryptedChar = 1;
            int currChar = data.charAt(i);
            for (long j = pubKey; j > 0; j--) {
                encryptedChar *= currChar;
                encryptedChar %= n;
            }
            enMessage.append(encryptedChar).append("O");
        }

        return enMessage.substring(0, enMessage.length());
    }


    @Override
    public String decrypt(String data) {
        String[] chars = data.split("O");
        long[] letters = new long[chars.length];
        for (int i = 0; i < chars.length; i++) {
            letters[i] = Long.parseLong(chars[i]);
        }

        StringBuilder deMessage = new StringBuilder();
        for (long letter : letters) {
            long decryptChar = 1;
            for (long j = prvKey; j > 0; j--) {
                decryptChar *= letter;
                decryptChar %= n;
            }
            deMessage.append((char) decryptChar);
        }

        return deMessage.toString();
    }


    private void generateKeys() {
        int l1, l2;
        long prime1, prime2;
        l1 = randInt(primes.length);
        do {
            l2 = randInt(primes.length);
        }
        while (l2 == l1);
        prime1 = primes[l1];
        prime2 = primes[l2];

        n = prime1 * (prime2);
        long fi = (prime1 - 1) * (prime2 - 1);
        long e = 2;
        long d = 2;

        while (!(gcd(e, fi) == 1)) {
            e++;
        }
        pubKey = e;

        while (!((d * e) % fi == 1)) {
            d++;
        }
        prvKey = d;
    }


    private int randInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }

    private long gcd(long a, long b) {
        while (true) {
            if (a % b == 0)
                return b;
            long t = b;
            b = a % b;
            a = t;
        }
    }
}
