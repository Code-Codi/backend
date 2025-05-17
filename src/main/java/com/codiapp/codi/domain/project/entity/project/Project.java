package com.codiapp.codi.domain.project.entity.project;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;
	
	@Column(nullable = true)
	private Date startDate;
	
	@Column(nullable = true)
	private Date endDate;
	
	@Column(nullable = true)
	private Date targetDeadline;
	
	@Column(nullable = true)
	private Date deadline;
	
	@Column(nullable = true)
	private String priority;
	
	@Column(nullable = true)
	private boolean repeat;
	
	@Column(nullable = true)
	private int progressPercent;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	//나중에 팀정보로 수정
	@Column(nullable = false)
	private int teamId;
	
	
}
