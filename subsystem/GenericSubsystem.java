package frc.rainstorm.subsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * Generic demo subsystem with setPower() and stop() methods.
 * Also includes a getRunCommand() method to create a simple
 * RunCommand with a power supplier.
 */

public class GenericSubsystem extends DemoSubsystemBase {

    protected final String name;

    protected MotorController motor;

    /**
     * Create a new GenericSubsystem with a base power and motor controller.
     *
     * @param name      subsystem name
     * @param basePower base power limit
     * @param motor     motor controller
     */
    public GenericSubsystem(String name, double basePower, MotorController motor) {
        super(basePower);

        if (name != null) {
            super.setName(name);
        }

        this.name = name;
        this.motor = motor;
    }

    public GenericSubsystem(double basePower, MotorController motor) {
        this(null, basePower, motor);
    }

    public GenericSubsystem(String name) {
        this(name, 0d, null);
    }

    public GenericSubsystem() {
        this(null, 0d, null);
    }

    /**
     * Gets power setting command
     * 
     * @param power power
     * @return new RunCommand
     */
    public Command getPowerCommand(DoubleSupplier power) {
        return startEnd(() -> setPower(power.getAsDouble()), this::stop);
    }

    /**
     * Set the power of the motor controller.
     *
     * @param power power
     */
    public void setPower(double power) {
        if (this.motor == null)
            return;
        motor.set(parsePowerLimit(power));
    }

    /**
     * Stop the motor controller.
     */
    public void stop() {
        setPower(0d);
    }

    /**
     * Periodic for shuffleboard updates
     */
    @Override
    public void periodic() {
        super.periodic();
    }
}
