/**
 * 
 */
package com.file.system.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.file.system.exception.EncryptException;

/**
 * 密码加密工具类
 * 
 * @author file
 * 
 */
public final class EncryptUtil {
	private static final String ALGORITHM = "DES";
	private static EncryptUtil INSTANCE = null;

	private EncryptUtil() {
	}

	public synchronized static EncryptUtil getInstance() {
		if (INSTANCE == null)
			INSTANCE = new EncryptUtil();
		return INSTANCE;
	}
	public String encrypt(String data,String key) throws EncryptException {
		return new String(encrypt(data.getBytes(), key));
	}
	public String encrypt(String data) throws EncryptException {
		return new String(encrypt(data.getBytes()));
	}

	private byte[] encrypt(byte[] data, String key) throws EncryptException {
		byte[] result = null;
		Cipher cipher = null;
		try {
			Key _key = initKey(key);
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, _key);
			result = cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		}

		return result;
	}
	
	private byte[] encrypt(byte[] data) throws EncryptException {
		byte[] result = null;
		Cipher cipher = null;
		try {
			Key _key = initKey();
			cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, _key);
			result = cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		} catch (BadPaddingException e) {
			e.printStackTrace();
			throw new EncryptException("EDS加密失败！", e);
		}

		return result;
	}
	
	private Key initKey() throws NoSuchAlgorithmException {
		return initKey(null);
	}

	private Key initKey(String seed) throws NoSuchAlgorithmException {
		SecureRandom secureRandom = null;

		if (seed != null) {
			secureRandom = new SecureRandom(seed.getBytes());
		} else {
			secureRandom = new SecureRandom();
		}

		KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
		kg.init(secureRandom);

		SecretKey secretKey = kg.generateKey();

		return secretKey;
	}

}
