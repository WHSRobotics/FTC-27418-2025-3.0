// Written by: Christopher Gholmieh (reviewed by Anik Koirala)
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Subsystems.Mecanum.Mecanum;
import org.whitneyrobotics.ftc.teamcode.Constants.Channel.Channel;
import com.qualcomm.robotcore.hardware.HardwareMap;


// Class:
public class Implementation {
    // Variables (Declaration):
    private static Implementation singleton_instance;
    public Mecanum mecanum;

    // Constructor:
    public Implementation(HardwareMap hardware_map) {
        mecanum = new Mecanum(hardware_map);
    }

    public Implementation() {}

    // Methods:
    public static Implementation getInstance(HardwareMap hardware_map) {
        if (singleton_instance == null) {
            singleton_instance = new Implementation(hardware_map);
        }

        return singleton_instance;
    }

    public static Implementation getInstance() {
        if (singleton_instance == null) {
            singleton_instance = new Implementation();
        }

        return singleton_instance;
    }

    public void update(Channel channel) {
        mecanum.update(channel);
    }
}
