package com.bit.boot09.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CryptServiceTest {
	String msg;
	@Autowired
	CryptService cryptService;

	@BeforeEach
	void setUp() throws Exception {
		msg="abcd1234";
	}

	@Test
	void test1() {
		System.out.println(cryptService.createMd5Encrypt(msg));
		System.out.println(cryptService.createSha256Encrypt(msg));
		System.out.println(cryptService.createSha512Encrypt(msg));
	}
	@Test//Sg1ih13+LL2tGo6Nlf/JiA==
	void test2() throws Exception {
		String result1=cryptService.createAESEncrypt(msg);
		String result2=cryptService.createAESDecrypt(result1);
		System.out.println(result1);
		System.out.println(result2);

		result1=cryptService.createAESEncrypt(msg);
		result2=cryptService.createAESDecrypt(result1);
		System.out.println(result1);
		System.out.println(result2);
	}

	@Test
	void test03() {
		String result=cryptService.springEncrypt(msg);
		System.out.println(result);
		System.out.println(cryptService.isMatches(msg, result));
		System.out.println(cryptService.isMatches(msg, "$2a$10$QMfQyJyumGuf0RCy0gCyEO6ly5FQX0bVl0peeI.evgqnU2igu27cy"));
		System.out.println(cryptService.isMatches(msg, "$2a$10$M.qQvPFTjA46X8jO6A8uUulS.TxcVbFiGBMuyDafQyRlL839Udb2e"));
		System.out.println(cryptService.isMatches(msg, "$2a$10$M.qQvPFTjA46X8jO6A8uUulS.sadfEFE23@uyDafQyRlL839Udb2e"));
	}
}






