package com.example.codi.controller;

//회의록 작성, 수정, 조회를 처리하는 컨트롤러
@RestController
@RequestMapping("/meetings")
public class MeetingController {

 private final MeetingService meetingService;

 public MeetingController(MeetingService meetingService) {
     this.meetingService = meetingService;
 }

 @PostMapping
 public ResponseEntity<Long> createMeeting(@RequestBody MeetingDto meetingDto) { }

 @PutMapping("/{meetingId}")
 public ResponseEntity<Void> updateMeeting(@PathVariable Long meetingId, @RequestBody MeetingDto meetingDto) { }

 @GetMapping("/{meetingId}")
 public ResponseEntity<MeetingDto> getMeeting(@PathVariable Long meetingId) { }

 @GetMapping
 public ResponseEntity<List<MeetingDto>> getAllMeetings() { }
}
