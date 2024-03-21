package frc.rainstorm;

import edu.wpi.first.wpilibj2.command.Command;

public class RainstormContainer {

    protected final RainstormInput input;

    public RainstormContainer() {
        this.input = new RainstormInput();
    }

    protected void configureButtonBindings() {
    }

    protected void configureDefaultCommands() {
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
