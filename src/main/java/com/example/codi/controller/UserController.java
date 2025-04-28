package com.example.codi.controller;

//사용자 컨트롤러
@RestController
@RequestMapping("/Users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> update(@PathVariable String userId, @RequestBody userDto userDto) {
        userService.updateUser(userId, userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}