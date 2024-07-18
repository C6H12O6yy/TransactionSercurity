package com.example.demo.exception;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler({ NoSuchAlgorithmException.class, InvalidKeyException.class, NoSuchPaddingException.class,
			BadPaddingException.class, IllegalBlockSizeException.class, Exception.class })
	public ResponseEntity<String> handleException(Exception ex) {
		String maskedMessage = maskSensitiveInformation(ex.getMessage());
		if (ex instanceof NoSuchAlgorithmException || ex instanceof NoSuchPaddingException
				|| ex instanceof InvalidKeyException || ex instanceof BadPaddingException
				|| ex instanceof IllegalBlockSizeException) {
			logger.error(maskedMessage, ex);
		}
		return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private String maskSensitiveInformation(String message) {
		return message.replaceAll("\\b(\\d{4})(\\d{4})(\\d{4})(\\d{4})\\b", "****")
				.replaceAll("\\b(TransactionID|Account|InDebt|Have|Time)\\b", "?");
	}
}
