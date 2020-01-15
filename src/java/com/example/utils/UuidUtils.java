package com.example.utils;

import java.util.UUID;

/**
 * @author wenqsh
 */
public class UuidUtils {

    public static String generateCode(String prex) {
        int hashCode = UUID.randomUUID().toString().hashCode();
        String length = String.valueOf(30 - prex.length());
        String uuid = String.format("%0" + length + "d", hashCode);
        return prex + uuid;
    }
}