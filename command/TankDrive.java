// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.rainstorm.command;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.rainstorm.subsystem.DemoDrivetrain;
import frc.rainstorm.subsystem.DemoSubsystemBase;

public class TankDrive extends Command {

    private DemoDrivetrain drivetrain;

    private DoubleSupplier leftPower;
    private DoubleSupplier rightPower;

    /**
     * Tank drive command
     *
     * @param <DT>       DemoDrivetrain type
     * @param drivetrain drivetrain subsystem
     * @param leftPower  left power
     * @param rightPower right power
     */
    public <DT extends DemoSubsystemBase & DemoDrivetrain> TankDrive(DT drivetrain, DoubleSupplier leftPower,
            DoubleSupplier rightPower) {
        this.drivetrain = drivetrain;
        this.leftPower = leftPower;
        this.rightPower = rightPower;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        drivetrain.tankDrive(leftPower.getAsDouble(), rightPower.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0d, 0d);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
