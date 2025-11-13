package com.cjbdevlabs.designpatterns.behavioral;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/*
Used to breakdown large systems into smaller parts, with lots of dependencies between them. Provide a simple
interface to complex systems.
 */
public class FacadePattern {

    static class Client {

        public static void main(String[] args) throws NoSuchAlgorithmException,
                NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException,
                IllegalBlockSizeException, BadPaddingException {

            String input = "Some text to encrypt";

            var encryptionFacade = new EncryptionFacade();
            encryptionFacade.encrypt(input);

        }
    }

    static class EncryptionFacade {

        public void encrypt(String input)
                throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException,
                InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey key = keyGenerator.generateKey();

            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] iv = new byte[Cipher.getInstance("AES/CBC/PKCS5Padding").getBlockSize()];
            random.nextBytes(iv);
            var ivParameterSpec = new IvParameterSpec(iv);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            byte[] cipherText = cipher.doFinal(input.getBytes());
            var result = Base64.getEncoder()
                    .encodeToString(cipherText);

            System.out.println("Encrypted String: " + result);
        }
    }
}