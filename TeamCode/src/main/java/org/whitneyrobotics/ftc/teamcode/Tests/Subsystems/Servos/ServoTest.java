// Written by Anik Koirala

// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Subsystems.Servos;

// Imports:

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;


// Class:
@TeleOp(name = "WHS_27418_testing_servo", group="WHS_27418_test_servo")
public class ServoTest extends OpModeEx {
    // Variable (Declaration)
    Servo WHS_27418_test_servo;

    /* Methods

      Joystick's input is limited from 0 (no power) to 1 (full power)

     */

    // Constructor:
    @Override
    public void initInternal() {
        // Variable (Definition):
        WHS_27418_test_servo = hardwareMap.get(Servo.class, "WHS_27418_test_servo");
    }
    @Override
    protected void loopInternal() {
        // Logic:
        WHS_27418_test_servo.setPosition((gamepad1.LEFT_STICK_X.value() + 1) / 2);


    }
}