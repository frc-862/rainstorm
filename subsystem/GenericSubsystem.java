package frc.rainstorm.subsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

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
     * @param basePower base power limit
     * @param motor motor controller
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

    /**
     * Create a new GenericSubsystem with a motor controller.
     * @param power power
     * @return new RunCommand
     */
    public Command getStartEndCommand(DoubleSupplier power) {
        return startEnd(() -> setPower(power.getAsDouble()), this::stop);
    }

    /**
     * Set the power of the motor controller.
     * @param power power
     */
    public void setPower(double power) {
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
