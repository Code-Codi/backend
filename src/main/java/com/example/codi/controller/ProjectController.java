package com.example.codi.controller;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 모든 프로젝트 조회
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // 특정 프로젝트 조회
    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable String projectId) {
        return projectService.getProjectById(projectId);
    }

    // 프로젝트 생성
    @PostMapping
    public void createProject(@RequestBody Project project) {
        projectService.createProject(project);
    }

    // 프로젝트 수정
    @PutMapping("/{projectId}")
    public void updateProject(@PathVariable String projectId, @RequestBody Project project) {
        project.setProjectId(projectId);
        projectService.updateProject(project);
    }

    // 프로젝트 삭제
    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable String projectId) {
        projectService.deleteProject(projectId);
    }