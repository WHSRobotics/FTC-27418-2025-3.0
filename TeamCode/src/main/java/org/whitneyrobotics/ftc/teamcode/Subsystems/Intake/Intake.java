// Written by: Christopher Gholmieh (reviewed by Anik Koirala):
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Intake;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Constants.Subsystem.Subsystem;
import org.whitneyrobotics.ftc.teamcode.Constants.Channel.Channel;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


// Class:
public class Intake implements Subsystem {
    // Variables (Declaration):
    protected DcMotor horizontal_slide_right;
    protected DcMotor horizontal_slide_left;

    protected Servo intake_claw;

    // Variables (Assignment):
    protected final double conversion = 0.3;
    protected double power = 0.0;

    protected double feedforward = 0.1;

    protected Positions claw_position = Positions.CLAW_OPEN_POSITION;

    // Enumerations:
    public enum Positions {
        // Enumerations:
        // Closed:
        CLAW_CLOSED_POSITION(1.0),

        // Open:
        CLAW_OPEN_POSITION(0.0);

        // Fields:
        private final double claw_position;

        // Constructor:
        Positions(double claw_position) {
            this.claw_position = claw_position;
        }
    }

    // Constructor:
    public Intake(HardwareMap hardware_map) {
        // Variables (Definition):
        horizontal_slide_right = hardware_map.get(DcMotor.class, "horizontal-slide-right");
        horizontal_slide_left = hardware_map.get(DcMotor.class, "horizontal-slide-left");

        intake_claw = hardware_map.get(Servo.class, "intake-claw");

        // Initialization:
        horizontal_slide_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        horizontal_slide_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    // Methods:
    /**
     * 
     * @param minimum The minimum value that the value parameter has to be greater than.
     * @param value The value parameter that you would like to be clamped.
     * @param maximum The maximum value that the value parameter has to be less than.
     * 
     * @return The clamped value, or the value greater than minimum and less than maximum.
     */
    private double clamp(double minimum, double value, double maximum) {
        if (value < minimum) {
            return minimum;
        }

        if (value > maximum) {
            return maximum;
        }

        return value;
    }

    /**
     * Supplies the same power to both horizontal linear slides.
     * 
     * @param linear_slide_power The power you would like both linear slide motors to be set to.
     */
    private void synchronized_power(double linear_slide_power) {
        horizontal_slide_right.setPower(linear_slide_power);
        horizontal_slide_left.setPower(linear_slide_power);
    }

    /**
     * Give extra power when staying up so it doesn't fall
     * @param power The power you want
     * @param adjuster What power you need to stay up/hover
     */
    private double adjust(double power, double adjuster) {
        return (power>=0)?(power+adjuster):power;
    }

    /**
     * Adjusts the claw position to the desired position.
     *
     * @param claw_position The position you would like the claw to be set to.
     */
    private void adjust_claw(double claw_position) {
        intake_claw.setPosition(claw_position);
    }

    public double get_claw_position() {
        return intake_claw.getPosition();
    }

    public boolean captured() {
        if (get_claw_position() != claw_position.claw_position) {
            return true;
        } else return false;
    }

    @Override
    public void update(Channel channel) {
        // Power:
        power = clamp(-1.0, adjust((power + (-channel.gamepad_one_left_stick_x) * conversion), feedforward), 1.0);

        // Logic:
        // Slides:
        synchronized_power(power);

        // Claw:
        if (channel.gamepad_two_right_bumper) {
            if (claw_position == Positions.CLAW_OPEN_POSITION) {
                claw_position = Positions.CLAW_CLOSED_POSITION;
            } else claw_position = Positions.CLAW_OPEN_POSITION;
        }
        adjust_claw(claw_position.claw_position);



    }
}
