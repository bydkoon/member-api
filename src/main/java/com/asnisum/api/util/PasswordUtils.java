package com.asnisum.api.util;

import lombok.NoArgsConstructor;

import java.security.MessageDigest;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PasswordUtils {

    public static String encryptSHA256(String s) {
        return encrypt(s, "SHA-256");
    }

    public static String encrypt(String s, String messageDigest) {
        try {
            MessageDigest md = MessageDigest.getInstance(messageDigest);
            byte[] passBytes = s.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : digested) sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            return sb.toString();
        } catch (Exception e) {
            return s;
        }
    }
}