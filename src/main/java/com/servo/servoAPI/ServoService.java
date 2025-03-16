package com.servo.servoAPI;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Service;

@Service
public class ServoService {

    private final GpioController gpio;
    private final GpioPinPwmOutput servoPin;

    public ServoService() {
        gpio = GpioFactory.getInstance();
        servoPin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01); // Change GPIO pin as needed
        servoPin.setPwm(0);
    }

    public void turnLeft() {
        servoPin.setPwm(100); // Adjust PWM value as needed
    }

    public void turnRight() {
        servoPin.setPwm(200); // Adjust PWM value as needed
    }
}
