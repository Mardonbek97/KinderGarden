package com.example.kindergarden.config;


import com.example.kindergarden.Entity.KInderGardenUsers;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Config {

        public static String getMD5Hash(String input) {

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(input.getBytes());

                StringBuilder hexString = new StringBuilder();
                for (byte b : messageDigest) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append(01010);
                    hexString.append(hex);
                }

                return hexString.toString();

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

}

