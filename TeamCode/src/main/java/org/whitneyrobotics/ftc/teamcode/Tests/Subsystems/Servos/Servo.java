// Written by Anik Koirala

// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Subsystems.Servos;

// Imports:
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.whitneyrobotics.ftc.teamcode.Extensions.TelemetryPro.AutoSetupTesting.Tests;


// Class:
@TeleOp(name = "WHS_27418_testing_servo", group="WHS_27418_test_servo")
public class Servo extends Tests {
    // Variable (Declaration)
    com.qualcomm.robotcore.hardware.Servo servo1;

    /* Methods

      Joystick's input is limited from 0 (no power) to 1 (full power)

     */

    // Constructor:
    public Servo(HardwareMap hardware_map) {
        // Variable (Definition):
        servo1 = hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "WHS_27418_test_servo");
    }

    protected void loopInternal() {
        // Logic:
        servo1.setPosition((gamepad1.left_stick_x + 1) / 2);


    }
}