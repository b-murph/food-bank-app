/*
 *  (C) 2017 Richard Blumenthal, All rights reserved
 *  Regis University students are free to use this code for their own
 *  education purposes. Unauthorized duplication or distribution
 *  without the author's permission is strictly forbidden.
 */
package foodbankapp;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 *
 * 
 * Install Unlimited JCE Policy JDK8
 *   Backup existing local_policy.jar US_export_policy.jar files in
 *    Directory: $JAVA_HOME/jre/lib/security/
 *     where: $JAVA_HOME:  C:/Program Files/Java/   (Default)
 *                                              jdk1.8.0_131/jre
 *                                              jre1.8.0.131/
 *            (Note, NetBeans uses the jre inside the jdk directory.)
 * 
 * Download: jce_policy-8.zip
 * From: http://www.oracle.com/technetwork/java/javase/downloads/index.html
 * Extract All: local_policy.jar US_export_policy.jar
 * Replace: these new jar files in the jre/lib/security/ directory
 * 
 * @author Charitha Kankanamge
 * @author Stephen Moreau
 * @author Rickb
 */
public class EncryptionMgr {
    private static String md5(final String input) 
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        final MessageDigest md = MessageDigest.getInstance("MD5");
        // Ensure umlets etc. get encoded.
        //"UTF-8"
        final byte[] messageDigest = md.digest(input.getBytes("UTF-8"));
        final BigInteger number = new BigInteger(1, messageDigest);
        return String.format("%032x", number);
    }

    /**
     * 
     * 
     * @param mode
     * @param initialVectorString
     * @param secretKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     * @throws UnsupportedEncodingException 
     */
    private Cipher initCipher(final int mode, 
                              final String initialVectorString, 
                              final String secretKey)
            
            throws NoSuchAlgorithmException, NoSuchPaddingException, 
            InvalidKeyException, InvalidAlgorithmParameterException, 
            UnsupportedEncodingException 
    {
        
        final SecretKeySpec skeySpec = new SecretKeySpec(md5(secretKey).getBytes(), "AES");
        
        final IvParameterSpec initialVector = new IvParameterSpec(initialVectorString.getBytes());

        final Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");

        cipher.init(mode, skeySpec, initialVector);

        return cipher;

    }
 
    /**
     * 
     * 
     * @param dataToEncrypt
     * @param initialVector
     * @param secretKey
     * @return 
     */
    public String encrypt(final String dataToEncrypt, final String initialVector, final String secretKey) {

        String encryptedData = null;

        try {

            // Initialize the cipher

            final Cipher cipher = initCipher(Cipher.ENCRYPT_MODE, initialVector, secretKey);

            // Encrypt the data

            final byte[] encryptedByteArray = cipher.doFinal(dataToEncrypt.getBytes());

            // Encode using Base64

            encryptedData = (new BASE64Encoder()).encode(encryptedByteArray);

        } catch (Exception e) {

            System.err.println("Problem encrypting the data");

            e.printStackTrace();

        }

        return encryptedData;

    }

    /**
     * 
     * 
     * @param encryptedData
     * @param initialVector
     * @param secretKey
     * @return 
     */
    public String decrypt(final String encryptedData, final String initialVector, final String secretKey) {

        String decryptedData = null;

        try {

            // Initialize the cipher

            final Cipher cipher = initCipher(Cipher.DECRYPT_MODE, initialVector, secretKey);

            // Decode using Base64

            final byte[] encryptedByteArray = (new BASE64Decoder()).decodeBuffer(encryptedData);

            // Decrypt the data

            final byte[] decryptedByteArray = cipher.doFinal(encryptedByteArray);

            decryptedData = new String(decryptedByteArray, "UTF8");

        } catch (Exception e) {

            System.err.println("Problem decrypting the data");

            e.printStackTrace();

        }

        return decryptedData;
    }
}
