/**
 * 
 */
package com.gupan.estudo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gustavo
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "users")
public class UserDTO implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_user")
	private Long cdUser;
	
	@Column(name = "nm_user", nullable = false)
	private String nmUser;
	
	@Column(name = "ds_mail", nullable = false, unique = true)
	private String dsMail;
	
	@Column(name = "ds_password", nullable = false)
	private String dsPassword;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy/MM/dd", locale = "pt_BR", timezone = "America/Sao_Paulo")
	@Column(name = "dt_birth", nullable = false)
	private LocalDate dtBirth;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", locale = "pt_BR", timezone = "America/Sao_Paulo")
	@Column(name = "edited_at")
	private LocalDateTime editedAt;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return dsPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return dsMail;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
