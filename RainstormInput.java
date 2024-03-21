package frc.rainstorm;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class RainstormInput {

    private ArrayList<XboxController> rawXboxControllers;
    // private ArrayList<Joystick> rawJoysticks;

    private double triggerThresh = 0.2d;

    public RainstormInput() {
        this.rawXboxControllers = new ArrayList<XboxController>();
        // this.rawJoysticks = new ArrayList<Joystick>();
    }

    public XboxController getXbox(int i) {
        return rawXboxControllers.get(i);
    }

    // public Joystick getJoystick(int i) {
    //     return rawJoysticks.get(i);
    // }

    public void addXbox(XboxController controller) {
        rawXboxControllers.add(controller);
    }

    // public void addJoystick(Joystick joystick) {
    //     rawJoysticks.add(joystick);
    // }

    public DoubleSupplier getTrigger(int id) {
        return () -> getXbox(id).getRightTriggerAxis() - getXbox(id).getLeftTriggerAxis();
    }
    public DoubleSupplier getTrigger() {
        return rawXboxControllers.size() > 0 ? getTrigger(0) : () -> 0d;
    }

    public BooleanSupplier getBoolTrigger(int id) {
        return () -> getXbox(id).getLeftTriggerAxis() > triggerThresh || getXbox(id).getRightTriggerAxis() > triggerThresh;
    }
    public BooleanSupplier getAnyTrigger() {
        return rawXboxControllers.size() > 0 ? getBoolTrigger(0) : () -> false;
    }
}
