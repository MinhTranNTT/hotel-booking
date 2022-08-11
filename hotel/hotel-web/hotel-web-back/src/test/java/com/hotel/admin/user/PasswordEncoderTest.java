package com.hotel.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Test
	public void testEncoderPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "minhtran2022";
		
		String encoderPassword = encoder.encode(password);
		
		System.out.println(encoderPassword);
		
		boolean matches = encoder.matches(password, encoderPassword);
		
		assertThat(matches).isTrue();
	}
}
