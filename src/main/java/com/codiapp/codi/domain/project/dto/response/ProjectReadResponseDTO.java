package com.codiapp.codi.domain.project.dto.response;

import java.util.Date;

import com.codiapp.codi.domain.project.entity.project.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProjectReadResponseDTO {
	 	private Long id;
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
	    private String manager;
	    private int progressPercent;
	    private Status status;
	    private Long teamId;
}
