// Written by Anik Koirala

// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Subsystems.DcMotors;

// Imports:

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;


// Class:
@TeleOp(name = "WHS_27418_testing_dcmotor", group="WHS_27418_test_dcmotor")
public class DcMotorTest extends OpModeEx {
    // Variable (Declaration)
    DcMotor WHS_27418_test_dcmotor;

    /* Methods

      Joystick's input is limited from 0 (no power) to 1 (full power)

     */

    // Constructor:
    public void initInternal() {
        // Variable (Definition):
        WHS_27418_test_dcmotor = hardwareMap.get(DcMotor.class, "WHS_27418_test_dcmotor");
    }

    protected void loopInternal() {
        // Logic:
        WHS_27418_test_dcmotor.setPower((-gamepad1.LEFT_STICK_Y.value() + 1) / 2);


    }
}