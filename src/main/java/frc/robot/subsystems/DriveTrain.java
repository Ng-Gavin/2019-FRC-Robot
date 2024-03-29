/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ArcadeDrive;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark rfSpark = null;
  Spark rbSpark = null;
  Spark lfSpark = null;
  Spark lbSpark = null;

  DifferentialDrive differentialDrive = null;

  public DriveTrain(){
    rfSpark = new Spark(RobotMap.RIGHT_FRONT_SPARK);
    rbSpark = new Spark(RobotMap.RIGHT_BACK_SPARK);
    lfSpark = new Spark(RobotMap.LEFT_FRONT_SPARK);
    lbSpark = new Spark(RobotMap.LEFT_BACK_SPARK);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(rfSpark, rbSpark);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(lfSpark, lbSpark);
  
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed){
          differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);

  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArcadeDrive());
  }
}
