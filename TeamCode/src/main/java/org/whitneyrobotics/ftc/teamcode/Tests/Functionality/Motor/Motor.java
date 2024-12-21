// Written by: Christopher Gholmjeh
// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Functionality.Motor;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


// Test:
@TeleOp(name = "27418-functionality-motor-test", group = "27418-functionality-tests")
public class Motor extends OpModeEx {
    // Variables (Declaration):
    public DcMotor motor;

    // Enumerations:
    public enum Directions {
        // Enumerations:
        // Forward:
        FORWARD(0.5),

        // Reverse:
        REVERSE(-0.5),

        // Inert:
        INERT(0.0);

        // Fields:
        // Value:
        public double value;

        // Constructor:
        Directions(double value) {
            this.value = value;
        }
    }

    // Intialization:
    @Override
    public void initInternal() {
        // Variables (Assignment):
        motor = hardwareMap.get(DcMotor.class, "motor");
    }

    // Loop:
    @Override
    public void loopInternal() {
        // Forward:
        gamepad1.BUMPER_LEFT.onPress(() -> {
            motor.setPower(Directions.FORWARD.value);
        });

        // Reverse:
        gamepad1.BUMPER_RIGHT.onPress(() -> {
            motor.setPower(Directions.REVERSE.value);
        });

        // Inert:
        gamepad1.BUMPER_LEFT.onRelease(() -> {
            motor.setPower(Directions.INERT.value);
        });

        gamepad1.BUMPER_RIGHT.onRelease(() -> {
            motor.setPower(Directions.INERT.value);
        });
    }
}