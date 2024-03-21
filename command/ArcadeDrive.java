// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.rainstorm.command;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.rainstorm.subsystem.DemoDrivetrain;
import frc.rainstorm.subsystem.DemoSubsystemBase;

public class ArcadeDrive extends Command {

    private DemoDrivetrain drivetrain;

    private DoubleSupplier speed;
    private DoubleSupplier rotation;

    /**
     * Arcade drive command
     *
     * @param <DT>       DemoDrivetrain type
     * @param drivetrain drivetrain
     * @param speed      speed
     * @param rotation   rotation
     */
    public <DT extends DemoSubsystemBase & DemoDrivetrain> ArcadeDrive(DT drivetrain, DoubleSupplier speed,
            DoubleSupplier rotation) {
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.rotation = rotation;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
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
