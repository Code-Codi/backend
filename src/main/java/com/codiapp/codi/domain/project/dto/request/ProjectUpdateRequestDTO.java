package com.codiapp.codi.domain.project.dto.request;

import java.util.Date;

import com.codiapp.codi.domain.project.entity.project.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectUpdateRequestDTO {

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

	    private Status status;

	    private String manager;
	
}
