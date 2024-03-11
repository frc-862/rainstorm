// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.rainstorm.subsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.rainstorm.shuffleboard.DemoShuffleboard;

public class DemoSubsystemBase extends SubsystemBase {

    private boolean limitEnabled;
    private double powerLimit;

    /**
     * Create a new RainstormSubsystemBase with a base power limit.
     * @param basePowerLimit
     */
    public DemoSubsystemBase(double basePowerLimit) {
        this.powerLimit = basePowerLimit;
        this.limitEnabled = true;
    }
    public DemoSubsystemBase() {
        this(1d);
        this.limitEnabled = false;
    }

    /**
     * Calculates the power based on limit
     * @param power input power
     * @return output power
     */
    public double parsePowerLimit(double power) {
        return power * this.powerLimit;
    }

    /**
     * @return power limit
     */
    public double getPowerLimit() {
        return this.powerLimit;
    }

    /**
     * Sets the power limit
     * @param demoLimit new power limit
     */
    public void setPowerLimit(double demoLimit) {
        this.powerLimit = demoLimit;
    }

    @Override
    public void periodic() {
        /* Update Shuffleboard */
        if (this.limitEnabled) {
            this.powerLimit = Math.min(DemoShuffleboard.createDemoLimit(getName(), this.powerLimit).getAsDouble(), 1d);
        }
    }
}
