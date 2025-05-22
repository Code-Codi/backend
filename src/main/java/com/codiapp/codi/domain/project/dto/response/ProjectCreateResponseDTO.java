package com.codiapp.codi.domain.project.dto.response;

import java.time.LocalDateTime;
import java.util.Date;
import com.codiapp.codi.domain.project.entity.project.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProjectCreateResponseDTO {
	private Long id;
	private String name;
	private String description;
	private String priority;
	private Status status;
	private String manager;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date targetDeadline;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	private LocalDateTime createdAt;
}
