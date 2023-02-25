package com.example.hackillinois2023;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Player {
    private int id;
    private String email;
    private String username;
    private String password;
    private String password_hash;

    public Player(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        String MD5_Hash_String = md5(password);
        this.password_hash = MD5_Hash_String;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return password_hash;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    /* Algorithm obtained from https://mobikul.com/converting-string-md5-hashes-android/ */
    public String md5(String s) {
        try {
            /* Create MD5 Hash */
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            /* Create Hex String */
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
