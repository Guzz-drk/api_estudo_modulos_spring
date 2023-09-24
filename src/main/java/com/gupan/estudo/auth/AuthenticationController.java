package com.gupan.estudo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gupan.estudo.dto.UserDTO;
import com.gupan.estudo.record.DadosAutenticacao;
import com.gupan.estudo.record.DadosTokenJWT;
import com.gupan.estudo.repository.UserRepository;

@RestController
@RequestMapping(value = "/login")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody @Validated DadosAutenticacao dados){
		Long cdTypeUser = userRepository.getCdTypeUserByDsEmail(dados.mail());
		if(cdTypeUser == 3 || cdTypeUser == 4) {
			var token = new UsernamePasswordAuthenticationToken(dados.mail(), dados.password());
			var authentication = manager.authenticate(token);
			var tokenJWT = tokenService.gerarToken((UserDTO) authentication.getPrincipal());
			return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));	
		} else {
			return ResponseEntity.badRequest().body("Usuário sem permissão de acesso!");
		}
	}
}
