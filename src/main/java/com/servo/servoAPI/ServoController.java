package com.servo.servoAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servo")
public class ServoController {

    private final ServoService servoService;

    public ServoController(ServoService servoService) {
        this.servoService = servoService;
    }

    @GetMapping("/turnServoLeft")
    public String turnLeft() {
        servoService.turnLeft();
        return "Servo turned left";
    }

    @GetMapping("/turnServoRight")
    public String turnRight() {
        servoService.turnRight();
        return "Servo turned right";
    }
}
