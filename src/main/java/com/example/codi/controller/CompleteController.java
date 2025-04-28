package com.example.codi.controller;

//완성본 컨트롤러
@RestController
@RequestMapping("/completes")
public class CompleteController {
  private final CompleteService completeService;

  public CompleteController(CompleteService completeService) {
      this.completeService = completeService;
  }

  @PostMapping
  public ResponseEntity<Long> createComplete(@RequestBody CompleteDto completeDto) {
      return ResponseEntity.ok(completeService.createComplete(completeDto));
  }

  @DeleteMapping("/{completeId}")
  public ResponseEntity<Void> deleteComplete(@PathVariable Long completeId) {
      completeService.deleteComplete(completeId);
      return ResponseEntity.ok().build();
  }

  @GetMapping("/{completeId}")
  public ResponseEntity<CompleteDto> getComplete(@PathVariable Long completeId) {
      return ResponseEntity.ok(completeService.getComplete(completeId));
  }

  @GetMapping
  public ResponseEntity<List<CompleteDto>> getAllCompletes() {
      return ResponseEntity.ok(completeService.getAllCompletes());
  }
}
