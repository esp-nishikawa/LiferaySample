package jp.co.esp.sample.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * ハッシュユーティリティ
 */
public final class HashUtil {

    /** 文字コード */
    public static final String CHARSET = "UTF-8";

    /** SHA-256 */
    private static final String SHA_256 = "SHA-256";

    /** SHA-512 */
    private static final String SHA_512 = "SHA-512";

    /**
     * コンストラクタ
     */
    private HashUtil() {}

    /**
     * SHA-256でハッシュ化
     *
     * @param source ハッシュ化する文字列
     * @return ハッシュ化文字列（BASE64）
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public static String sha256(String source)
            throws IOException, GeneralSecurityException {
        final MessageDigest messageDigest = MessageDigest.getInstance(SHA_256);
        final byte[] hashData = messageDigest.digest(source.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(hashData);
    }

    /**
     * SHA-512でハッシュ化
     *
     * @param source ハッシュ化する文字列
     * @return ハッシュ化文字列（BASE64）
     * @throws IOException 入出力例外
     * @throws GeneralSecurityException セキュリティ例外
     */
    public static String sha512(String source)
            throws IOException, GeneralSecurityException {
        final MessageDigest messageDigest = MessageDigest.getInstance(SHA_512);
        final byte[] hashData = messageDigest.digest(source.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(hashData);
    }
}
