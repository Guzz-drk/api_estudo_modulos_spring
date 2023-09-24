package com.gupan.estudo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "class")
public class ClassDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_class", nullable = false)
	private Long cdClass;
	
	@Column(name = "ds_num_class")
	private String dsNumClass;
	
	@Column(name = "ds_recommended_quarter")
	private String dsRecommendedQuarter;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", locale = "pt_BR", timezone = "America/Sao_Paulo")
	@Column(name = "edited_at")
	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDateTime editedAt;

	public ClassDTO(Long cdClass) {
		super();
		this.cdClass = cdClass;
	}
}
