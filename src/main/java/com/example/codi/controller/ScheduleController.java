package com.example.codi.controller;

//스케쥴 등록, 조회, 수정, 삭제를 처리하는 컨트롤러
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

 private final ScheduleService scheduleService;

 public ScheduleController(ScheduleService scheduleService) {
     this.scheduleService = scheduleService;
 }

 @PostMapping
 public ResponseEntity<Long> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
     Long scheduleId = scheduleService.insertSchedule(schedule);
     return ResponseEntity.ok(scheduleId);
 }

 @GetMapping("/{scheduleId}")
 public ResponseEntity<Schedule> getScheduleById(@PathVariable Long scheduleId) {
     Schedule schedule = scheduleService.findScheduleById(scheduleId);
     return ResponseEntity.ok(schedule);
 }

 @GetMapping("/team/{teamId}")
 public ResponseEntity<List<Schedule>> getSchedulesByTeamId(@PathVariable Long teamId) {
     List<Schedule> schedules = scheduleService.findSchedulesByTeamId(teamId);
     return ResponseEntity.ok(schedules);
 }

 @PutMapping("/{scheduleId}")
 public ResponseEntity<Void> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleDTO scheduleDTO) {
     scheduleService.updateSchedule(schedule);
     return ResponseEntity.ok().build();
 }

 @DeleteMapping("/{scheduleId}")
 public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
     scheduleService.deleteSchedule(scheduleId);
     return ResponseEntity.ok().build();
 }
}
