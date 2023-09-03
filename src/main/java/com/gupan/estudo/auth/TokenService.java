package com.gupan.estudo.auth;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gupan.estudo.dto.UserDTO;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secretKey;
	
	public String gerarToken(UserDTO user) {
		try {
			var algoritmo = Algorithm.HMAC256(secretKey);
			return JWT.create()
					.withIssuer("Api-Estudo-Modulos-Spring")
					.withSubject(user.getDsMail())
					.withClaim("cdUser", user.getCdUser())
					.withExpiresAt(dataExpiracao())
					.sign(algoritmo);
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro ao gerar token! ", e);
		}
	}
	
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusMonths(1).toInstant(ZoneOffset.of("-03:00"));
	}
	
	public String getSubject(String tokenJWT) {
		try {
			var algoritmo = Algorithm.HMAC256(secretKey);
			return JWT.require(algoritmo)
					.withIssuer("Api-Estudo-Modulos-Spring")
					.build().verify(tokenJWT).getSubject();
		} catch (JWTVerificationException e) {
			throw new RuntimeException("Token inválido ou expirado! ", e);
		}
	}
}
