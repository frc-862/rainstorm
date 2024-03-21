// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.rainstorm.subsystem;

public interface IRainstormDemoLimits {

    public double parsePowerLimit(double power);

    public double getPowerLimit();

    public void setPowerLimit(double power);

}
