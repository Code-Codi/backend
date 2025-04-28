package com.example.codi.controller;

//로그인 컨트롤러
@RestController
@RequestMapping("/auth")
public class LoginController {
 private final UserService userService;

 public LoginController(UserService userService) {
     this.userService = userService;
 }

 @PostMapping("/login")
 public ResponseEntity<UserSessionDto> login(@RequestBody LoginDto loginDto) {
     return ResponseEntity.ok(userService.login(loginDto));
 }

 @PostMapping("/logout")
 public ResponseEntity<Void> logout() {
     return ResponseEntity.ok().build();
 }
}
