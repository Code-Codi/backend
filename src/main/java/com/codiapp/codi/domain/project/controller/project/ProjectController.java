package com.codiapp.codi.domain.project.controller.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codiapp.codi.domain.project.entity.project.Project;
import com.codiapp.codi.domain.project.service.project.ProjectService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import com.codiapp.codi.global.apiPayload.code.status.SuccessStatus;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
 // 프로젝트 전체 조회
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    
   //create
    @PostMapping
    public ApiResponse<String> createProject(@RequestBody Project project) {
        try {
            project.setTeamId(1); //팀 ID 하드코딩. 추후 수정
            projectService.createProject(project);
            return ApiResponse.of(SuccessStatus._OK, "프로젝트가 성공적으로 등록되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.onFailure("PROJECT4001", "프로젝트 등록 중 오류가 발생했습니다.", null);
        }
    }

    //update
    @PutMapping("/{id}")
    public ApiResponse<String> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        try {
            project.setId(id); // ID 설정
            projectService.updateProject(project);
            return ApiResponse.of(SuccessStatus._OK, "프로젝트가 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            return ApiResponse.onFailure("PROJECT4002", "프로젝트 수정 중 오류가 발생했습니다.", null);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteProject(@PathVariable("id") int id) {
        try {
            projectService.deleteProject(id);
            return ApiResponse.of(SuccessStatus._OK, "프로젝트가 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            return ApiResponse.onFailure("PROJECT4003", "프로젝트 삭제 중 오류가 발생했습니다.", null);
        }
    }


}
