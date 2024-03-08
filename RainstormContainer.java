package frc.rainstorm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RainstormContainer {
    
    protected final XboxController controller;

    public RainstormContainer(XboxController controller) {
        this.controller = controller;
    }

    protected void configureButtonBindings() {}

    protected void configureDefaultCommands() {}

    protected DoubleSupplier getTrigger() {
        return () -> controller.getRightTriggerAxis() - controller.getLeftTriggerAxis();
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
