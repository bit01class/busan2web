package com.bit.boot09.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CryptService {
	
	final PasswordEncoder passwordEncoder;
	
//	@Value("${my.secure.key}")
	public String key="oingisprettyinth";//AES 암호화를 하는데 사용되는 Key는 16, 24, 32 byte 
    private String iv = "0123456789abcdef"; // 16byte

	// 암호화
	// 단방향 - > 암호화 -> 복호화불가
	// 양방향 - > 암호화(key) -> 복호화가능(key)
	public String createMd5Encrypt(String msg) {
		return DigestUtils.md5Hex(msg);
	}
	public String createSha256Encrypt(String msg) {
		String result=DigestUtils.sha256Hex(msg.getBytes());
		return new String(result);
	}
	public String createSha512Encrypt(String msg) {
		return DigestUtils.sha3_512Hex(msg);
	}
	
	SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
	public String createAESEncrypt(String msg) throws Exception {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
	     c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
	     byte[] encrypted = c.doFinal(msg.getBytes("UTF-8"));
	     String enStr = new String(Base64.encodeBase64(encrypted));
	     return enStr;
	}
	public String createAESDecrypt(String msg) throws Exception {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
	      c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
	      byte[] byteStr = Base64.decodeBase64(msg.getBytes());
	      return new String(c.doFinal(byteStr), "UTF-8");
	}
	
	public String springEncrypt(String msg) {
		return passwordEncoder.encode(msg);
	}
	
	public boolean isMatches(String msg,String enctext) {
		return passwordEncoder.matches(msg, enctext);
	}
}






