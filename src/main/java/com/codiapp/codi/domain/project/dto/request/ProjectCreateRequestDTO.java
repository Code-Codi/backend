package com.codiapp.codi.domain.project.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.codiapp.codi.domain.project.entity.project.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectCreateRequestDTO {

	@NotNull(message = "팀 ID는 필수입니다.")
	private Long teamId;
	
	@NotBlank(message = "프로젝트 이름은 필수입니다.")
	@Size(max = 50, message = "이름은 최대 50자까지 입력할 수 있습니다.")
	private String name;
	
	private String description;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date targetDeadline;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	
	private String priority;
	
	
	@Min(value = 0, message = "진행률은 0 이상이어야 합니다.")
    @Max(value = 100, message = "진행률은 100 이하이어야 합니다.")
	private int progressPercent;
	
	private Status status;
	
	private String manager;
	
	
}
