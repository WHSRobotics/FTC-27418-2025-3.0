// Written By Anik Koirala
// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Functionality.Servo;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


// Test:
@TeleOp(name = "27418-functionality-servo-test", group = "27418-functionality-tests")
public class ServoTest extends OpModeEx {
    // Variables (Declaration)
    public Servo servo;

    // Enumeration:
    public enum Positions {
        // Enumerations:
        // Forward:
        FORWARD (0.5),

        // Reverse:
        REVERSE (0.5),

        // Inert:
        INERT(0.0);

        // Fields:
        public double value;

        // Constructor:
        Positions(double value) {
            this.value = value;
        }

    }

    // Initialization:
    @Override
    public void initInternal() {
        // Variables (Assignment):
        servo = hardwareMap.get(Servo.class, "servo");
    }

    // Loop:
    @Override
    protected void loopInternal() {
        gamepad1.BUMPER_LEFT.onPress(() -> {
            servo.setPosition(Positions.FORWARD.value);
        });

        gamepad1.BUMPER_RIGHT.onPress(() -> {
            servo.setPosition(Positions.REVERSE.value);
        });

        gamepad1.BUMPER_LEFT.onRelease(() -> {
            servo.setPosition(Positions.INERT.value);

        });
        gamepad1.BUMPER_RIGHT.onRelease(() -> {
            servo.setPosition(Positions.INERT.value);
        });
    }
}
