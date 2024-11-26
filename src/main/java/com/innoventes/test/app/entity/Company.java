package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name", nullable = false)
	@Size(min=5)
	@NotBlank(message = "Company name can not be blank")
	private String companyName;

	@Column(name = "email", unique = true)
	@NotBlank(message = "Email can not be blank")
	@Email
	private String email;
	
	@Column(name = "strength")
	private Integer strength;
	
	@Column(name = "website_url", nullable = true)
	private String webSiteURL;

	@Column(name = "company_code", nullable = true, unique = true)
	@Size(min = 5)
	private String companyCode;
}
