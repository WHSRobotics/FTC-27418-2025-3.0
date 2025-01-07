// Written By: Anik Koirala
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Ascend;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// Class:
@TeleOp(name = "Ascend-27418", group="Ascend-27418")
public class Ascend extends OpModeEx {
    // Variables (Declaration):
    protected DcMotor vertical_linear_slides;

    // Enumerations
    public enum Positions {
        // Enumerations:
        // Closed:
        ASCEND_CLOSED_POSITION(0.0),

        // Extended:
        ASCEND_EXTENDED_POSITION(1.0);

        // Fields:
        private final double new_position;

        // Constructor:
        Positions(double new_position) {
            this.new_position = new_position;

        }
    }



    public void initInternal() {
        // Variable (Definition):
         vertical_linear_slides = hardwareMap.get(DcMotor.class, "vertical_linear_slides");
    }

    // Variable (Assignment):
    boolean status = false;

    // Methods:

    /**
     * Checks if gamepad1.A is pressed. If so, the boolean status variable toggles between true/false.
     * Checks if status variable is true. If so, interactions from gamepad1.LEFT_STICK_X will extend the vertical linear slides.
     * If the status variable is false, the vertical linear slides' position is set to closed.
     */

    @Override
    protected void loopInternal() {

        if (gamepad1.A.value()) {
             status = !status; // Switches the value of the status boolean variable to true/false
        }

        // Vertical Linear Slides:
        if(status) {
            gamepad1.LEFT_STICK_X.onInteraction(() -> {
                vertical_linear_slides.setPower(Positions.ASCEND_EXTENDED_POSITION.new_position);
            });
        } else {
            vertical_linear_slides.setPower(Positions.ASCEND_CLOSED_POSITION.new_position);
        }

    }
}
