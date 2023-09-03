package com.gupan.estudo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class UserEntity {
	
	@Id
	private Long cdUser;
	
	private String nmUser;
	
	private String typeUser;
	
	private String dsMail;
	
	private LocalDate dtBirth;
	
	private Long age;
}
