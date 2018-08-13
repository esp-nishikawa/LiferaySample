package jp.co.esp.sample.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * 暗号ユーティリティ
 */
public final class EncryptUtil {

    /** AES暗号化方式 */
    private static final String ALGORITHM_AES = "AES/ECB/PKCS5Padding";

    /** SHAハッシュ化方式 */
    private static final String ALGORITHM_SHA = "SHA-256";

    /** 暗号キー文字列 */
    private static final String RANDOM_ASSING_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!#";

    /**
     * コンストラクタ
     */
    private EncryptUtil() {
    }

    /**
     * AES暗号化
     *
     * @param source 暗号化する文字列
     * @param secretKey 暗号化キー
     * @return 暗号化した文字列
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public String encryptAes(String source, String secretKey)
            throws IOException, GeneralSecurityException {
        SecretKeySpec sec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
        cipher.init(Cipher.ENCRYPT_MODE, sec);
        byte[] encryptData = cipher.doFinal(source.getBytes("UTF-8"));

        // Base64 encode
        String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(encryptData);

        return encoded;
    }

    /**
     * AES復号化
     *
     * @param source 復号化する文字列
     * @param secretKey 暗号化キー
     * @return 復号化した文字列
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public String decryptAes(String source, String secretKey)
            throws IOException, GeneralSecurityException {
        // Base64 decode
        byte[] decoded = Base64.getUrlDecoder().decode(source);

        SecretKeySpec sec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
        cipher.init(Cipher.DECRYPT_MODE, sec);
        byte[] decryptData = cipher.doFinal(decoded);

        return new String(decryptData, "UTF-8");
    }

    /**
     * RSA暗号化
     *
     * @param source 暗号化する文字列
     * @param privateKeyData 秘密鍵データ
     * @return 暗号化した文字列
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public String encryptRsa(String source, byte[] privateKeyData)
            throws IOException, GeneralSecurityException {
        // 秘密鍵の読み込み
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyData);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encryptData = cipher.doFinal(source.getBytes("UTF-8"));

        // Base64 encode
        String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(encryptData);

        return encoded;
    }

    /**
     * RSA復号化
     *
     * @param source 復号化する文字列
     * @param publicKeyData 公開鍵データ
     * @return 復号化した文字列
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public String decryptRsa(String source, byte[] publicKeyData)
            throws IOException, GeneralSecurityException {
        // Base64 decode
        byte[] decoded = Base64.getUrlDecoder().decode(source);

        // 公開鍵の読み込み
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyData);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decryptData = cipher.doFinal(decoded);

        return new String(decryptData, "UTF-8");
    }

    /**
     * SHAハッシュ化
     *
     * @param source ハッシュ化する文字列
     * @return ハッシュ化した文字列
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public static String hashSha(String source)
            throws IOException, GeneralSecurityException {
        MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_SHA);
        byte[] hashData = messageDigest.digest(source.getBytes("UTF-8"));
        return DatatypeConverter.printHexBinary(hashData);
    }

    /**
     * 暗号化キーの生成
     *
     * @return String 暗号化キー
     */
    public static String createSecretKey() {
        SecureRandom secureRandom = new SecureRandom();

        // 16文字（128bit）
        char[] secretKey = new char[16];

        for (int i = 0; i < secretKey.length; i++) {
            secretKey[i] = RANDOM_ASSING_CHARS.charAt(secureRandom.nextInt(RANDOM_ASSING_CHARS.length()));
        }
        return new String(secretKey);
    }
}
