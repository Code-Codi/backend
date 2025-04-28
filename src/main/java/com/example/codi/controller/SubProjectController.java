package com.example.codi.controller;

@RestController
@RequestMapping("/subprojects")
public class SubProjectController {

    @Autowired
    private SubProjectService subProjectService;

    // 특정 프로젝트에 속한 서브프로젝트 조회
    @GetMapping("/project/{projectId}")
    public List<SubProject> getSubProjectsByProjectId(@PathVariable String projectId) {
        return subProjectService.getSubProjectsByProjectId(projectId);
    }

    // 특정 상태에 따라 서브프로젝트 조회
    @GetMapping("/project/{projectId}/status/{status}")
    public List<SubProject> getSubProjectsByStatus(@PathVariable String projectId, @PathVariable String status) {
        return subProjectService.getSubProjectsByStatus(projectId, status);
    }

    // 서브프로젝트 생성
    @PostMapping
    public void createSubProject(@RequestBody SubProject subProject) {
        subProjectService.createSubProject(subProject);
    }

    // 서브프로젝트 수정
    @PutMapping("/{subProjectId}")
    public void updateSubProject(@PathVariable String subProjectId, @RequestBody SubProject subProject) {
        subProject.setSubProjectId(subProjectId);
        subProjectService.updateSubProject(subProject);
    }

    // 서브프로젝트 삭제
    @DeleteMapping("/{subProjectId}")
    public void deleteSubProject(@PathVariable String subProjectId) {
        subProjectService.deleteSubProject(subProjectId);
    }
}
