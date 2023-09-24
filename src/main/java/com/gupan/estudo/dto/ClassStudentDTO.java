package com.gupan.estudo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gustavo
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "class_student")
public class ClassStudentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_class_student")
	private Long cdClassStudent;
	
	@OneToOne
	@JoinColumn(name = "cd_class")
	private ClassDTO cdClass;
	
	@ManyToOne
	@JoinColumn(name = "cd_user")
	private UserDTO cdUser;
}
