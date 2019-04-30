package me.luisphi.des;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DESede {
	
	String secretKey = "{ (byte) 0xFA, (byte) 0x83, (byte) 0x26, (byte) 0x81, (byte) 0x05, (byte) 0xD9, (byte) 0x4E, (byte) 0x2F, (byte) 0xFA, (byte) 0x83, (byte) 0x26, (byte) 0x81, (byte) 0x05, (byte) 0xD9, (byte) 0x4E, (byte) 0x2F, (byte) 0xFA, (byte) 0x83, (byte) 0x26, (byte) 0x81, (byte) 0x05, (byte) 0xD9, (byte) 0x4E, (byte) 0x2F }";
	
	public static void main(String[] args) throws Exception {

        String text = "ApisconAPPCir-8952";

        byte[] codedtext = new DESede().encrypt(text);
        String decodedtext = new DESede().decrypt(codedtext);

        byte[] b64 = Base64.getEncoder().encode(codedtext);
        System.out.println(new String(b64));
        System.out.println(decodedtext);
    }

    public byte[] encrypt(String message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("SHA-1");
        final byte[] digestOfPassword = md.digest(secretKey
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        
        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        
        final Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        final byte[] plainTextBytes = message.getBytes("utf-8");
        final byte[] cipherText = cipher.doFinal(plainTextBytes);
        
        return cipherText;
    }

    public String decrypt(byte[] message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("SHA-1");
        final byte[] digestOfPassword = md.digest(secretKey
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        
        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        
        final Cipher decipher = Cipher.getInstance("DESede");
        decipher.init(Cipher.DECRYPT_MODE, key);

        final byte[] plainText = decipher.doFinal(message);

        return new String(plainText, "UTF-8");
    }
}
