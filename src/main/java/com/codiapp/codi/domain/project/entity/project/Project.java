package com.codiapp.codi.domain.project.entity.project;



import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 2000, nullable = false)
	private String description;
	
	@Column(nullable = true)
	private Date startDate;
	
	@Column(nullable = true)
	private Date endDate;
	
	@Column(nullable = true)
	private Date targetDeadline;
	
	@Column(nullable = true)
	private Date deadline;
	
	@Column(length = 10, nullable = true)
	private String priority;
	
	@Column(length = 10, nullable = true)
	private String manager;
	
	@Column(nullable = true)
	private int progressPercent;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	//나중에 팀정보로 수정
	 @JoinColumn(name = "team_id", nullable = false)
	private Long teamId;
	
	
}
