package com.example.codi.controller;

//미디어 컨트롤러
@RestController
@RequestMapping("/media")
public class MediaController {
 private final MediaService mediaService;

 public MediaController(MediaService mediaService) {
     this.mediaService = mediaService;
 }

 @PostMapping
 public ResponseEntity<Long> uploadMedia(@RequestParam("file") MultipartFile file, 
                                        @RequestParam("mediaType") String mediaType,
                                        @RequestParam(value = "guideId", required = false) Long guideId,
                                        @RequestParam(value = "completeId", required = false) Long completeId) {
     MediaDto mediaDto = new MediaDto();
     mediaDto.setMediaType(mediaType);
     mediaDto.setGuideId(guideId);
     mediaDto.setCompleteId(completeId);
     
     return ResponseEntity.ok(mediaService.uploadMedia(file, mediaDto));
 }

 @GetMapping("/{mediaId}")
 public ResponseEntity<byte[]> getMedia(@PathVariable Long mediaId) {
     MediaDto mediaDto = mediaService.getMedia(mediaId);
     HttpHeaders headers = new HttpHeaders();
     headers.setContentType(MediaType.parseMediaType(mediaDto.getMediaType()));
     return new ResponseEntity<>(mediaDto.getMediaData(), headers, HttpStatus.OK);
 }

 @DeleteMapping("/{mediaId}")
 public ResponseEntity<Void> deleteMedia(@PathVariable Long mediaId) {
     mediaService.deleteMedia(mediaId);
     return ResponseEntity.ok().build();
 }
}