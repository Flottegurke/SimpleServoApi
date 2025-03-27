package com.servo.servoAPI;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.pwm.Pwm;
import com.pi4j.io.pwm.PwmProvider;
import org.springframework.stereotype.Service;

@Service
public class ServoService {

    private final Context pi4j;
    private final Pwm servoPwm;

    public ServoService() {

        pi4j = Pi4J.newAutoContext();

        PwmProvider pwmProvider = pi4j.provider("pigpio-pwm");

        servoPwm = pwmProvider.create(18, "PWM-18", "PWM on GPIO 18");


        servoPwm.frequency(50); // Set frequency to 50 Hz (for standard servos)

        servoPwm.dutyCycle(0); // Initial duty cycle (can be adjusted later)
    }

    public void turnLeft() {
        servoPwm.dutyCycle(0.05);
    }

    public void turnRight() {
        servoPwm.dutyCycle(0.10);
    }

    public void stop() {
        servoPwm.dutyCycle(0);
    }
}
