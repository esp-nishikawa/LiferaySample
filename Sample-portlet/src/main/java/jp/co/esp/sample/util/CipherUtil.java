package jp.co.esp.sample.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 暗号ユーティリティ
 */
public final class CipherUtil {

    /** 文字コード */
    public static final String CHARSET = "UTF-8";
    
    /** AESアルゴリズム */
    private static final String AES_ALGORITHM = "AES";

    /** RSAアルゴリズム */
    private static final String RSA_ALGORITHM = "RSA";

    /** 共通鍵による暗号化 */
    private static final String COMMON_KEY_TRANSFORMATION = "AES/ECB/PKCS5Padding";

    /** 非対称鍵による暗号化 */
    private static final String ASYMMETRY_KEY_TRANSFORMATION = "RSA/ECB/PKCS1Padding";

    /** ロックオブジェクト */
    private static final Object LOCK = new Object();

    /**
     * コンストラクタ
     */
    private CipherUtil() {}

    /**
     * AES暗号化
     *
     * @param plainText 平文
     * @param commonKey 共通鍵（128bit）
     * @return 暗号化した文字列（BASE64）
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public static String encryptAes(String plainText, String commonKey)
            throws IOException, GeneralSecurityException {
        final SecretKeySpec secretKeySpec = new SecretKeySpec(commonKey.getBytes(CHARSET), AES_ALGORITHM);
        final byte[] encryptData;

        synchronized (LOCK) {
            final Cipher cipher = Cipher.getInstance(COMMON_KEY_TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            encryptData = cipher.doFinal(plainText.getBytes(CHARSET));
        }
        return Base64.getEncoder().encodeToString(encryptData);
    }

    /**
     * AES復号化
     *
     * @param cryptedText 暗号化された文字列（BASE64）
     * @param commonKey 共通鍵（128bit）
     * @return 平文
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public static String decryptAes(String cryptedText, String commonKey)
            throws IOException, GeneralSecurityException {
        final byte[] decodedText = Base64.getDecoder().decode(cryptedText);
        final SecretKeySpec secretKeySpec = new SecretKeySpec(commonKey.getBytes(CHARSET), AES_ALGORITHM);
        final byte[] decryptData;

        synchronized (LOCK) {
            final Cipher cipher = Cipher.getInstance(COMMON_KEY_TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            decryptData = cipher.doFinal(decodedText);
        }
        return new String(decryptData, CHARSET);
    }

    /**
     * RSA暗号化
     *
     * @param plainText 平文
     * @param encodedPublicKey 公開鍵（BASE64）
     * @return 暗号化した文字列（BASE64）
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public static String encryptRsa(String plainText, String encodedPublicKey)
            throws IOException, GeneralSecurityException {
        final KeySpec keySpec = new X509EncodedKeySpec(Base64Util.decode(encodedPublicKey));
        final KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        final PublicKey publicKey = keyFactory.generatePublic(keySpec);
        byte[] encryptData;

        synchronized (LOCK) {
            final Cipher cipher = Cipher.getInstance(ASYMMETRY_KEY_TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            encryptData = cipher.doFinal(plainText.getBytes(CHARSET));
        }
        return Base64.getEncoder().encodeToString(encryptData);
    }

    /**
     * RSA復号化
     *
     * @param cryptedText 暗号化された文字列（BASE64）
     * @param encodedPrivateKey 秘密鍵（BASE64）
     * @return 平文
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public static String decryptRsa(String cryptedText, String encodedPrivateKey)
            throws IOException, GeneralSecurityException {
        final byte[] decodedText = Base64.getDecoder().decode(cryptedText);
        final KeySpec keySpec = new PKCS8EncodedKeySpec(Base64Util.decode(encodedPrivateKey));
        final KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        final PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        final byte[] decryptData;

        synchronized (LOCK) {
            Cipher cipher = Cipher.getInstance(ASYMMETRY_KEY_TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            decryptData = cipher.doFinal(decodedText);
        }
        return new String(decryptData, CHARSET);
    }
}
