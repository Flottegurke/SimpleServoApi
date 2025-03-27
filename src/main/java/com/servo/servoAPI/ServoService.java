package com.servo.servoAPI;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.pwm.Pwm;
import com.pi4j.io.pwm.PwmType;
import com.pi4j.io.pwm.PwmProvider;
import org.springframework.stereotype.Service;

@Service
public class ServoService {

    private final Context pi4j;
    private final Pwm servoPwm;

    public ServoService() {
        // Initialize Pi4J
        pi4j = Pi4J.newAutoContext();

        // Create PWM provider (Uses pigpio internally)
        PwmProvider pwmProvider = pi4j.provider("pigpio-pwm");

        // Provision PWM pin (GPIO 18 for example, update if needed)
        servoPwm = pwmProvider.create(18, PwmType.HARDWARE, 50); // 50 Hz for servos
    }

    public void turnLeft() {
        servoPwm.on(5); // Adjust pulse width as needed
    }

    public void turnRight() {
        servoPwm.on(10); // Adjust pulse width as needed
    }

    public void stop() {
        servoPwm.off();
    }
}
