package com.example.codi.controller;

//가이드 컨트롤러
@RestController
@RequestMapping("/guides")
public class GuideController {
 private final GuideService guideService;

 public GuideController(GuideService guideService) {
     this.guideService = guideService;
 }

 @PostMapping
 public ResponseEntity<Long> createGuide(@RequestBody GuideDto guideDto) {
     return ResponseEntity.ok(guideService.createGuide(guideDto));
 }

 @PutMapping("/{guideId}")
 public ResponseEntity<Void> updateGuide(@PathVariable Long guideId, @RequestBody GuideDto guideDto) {
     guideService.updateGuide(guideId, guideDto);
     return ResponseEntity.ok().build();
 }

 @DeleteMapping("/{guideId}")
 public ResponseEntity<Void> deleteGuide(@PathVariable Long guideId) {
     guideService.deleteGuide(guideId);
     return ResponseEntity.ok().build();
 }

 @GetMapping("/{guideId}")
 public ResponseEntity<GuideDto> getGuide(@PathVariable Long guideId) {
     return ResponseEntity.ok(guideService.getGuide(guideId));
 }

 @GetMapping
 public ResponseEntity<List<GuideDto>> getAllGuides() {
     return ResponseEntity.ok(guideService.getAllGuides());
 }
}
