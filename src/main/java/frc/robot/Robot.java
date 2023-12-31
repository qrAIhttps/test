// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Subsystems.Drivetrain;

public class Robot extends TimedRobot {
  private final XboxController m_controller = new XboxController(0);
  private final Drivetrain m_swerve = new Drivetrain();

  // Slew rate limiters to make joystick inputs more gentle; 1/3 sec from 0 to 1.
  private final SlewRateLimiter m_xspeedLimiter = new SlewRateLimiter(3);
  private final SlewRateLimiter m_yspeedLimiter = new SlewRateLimiter(3);
  private final SlewRateLimiter m_rotLimiter = new SlewRateLimiter(3);

  @Override
  public void autonomousPeriodic() {
    //driveWithJoystick(false);
    m_swerve.updateOdometry();
  }

  @Override
  public void teleopPeriodic() {
    driveWithJoystick(true);
    m_swerve.updateOdometry();
  }

  private void driveWithJoystick(boolean fieldRelative) {
    // Get the x speed. We are inverting this because Xbox controllers return
    // negative values when we push forward.
    final var xSpeed =
        -m_xspeedLimiter.calculate(MathUtil.applyDeadband(m_controller.getLeftY(), 0.02))
            * Drivetrain.kMaxSpeed;

    // Get the y speed or sideways/strafe speed. We are inverting this because
    // we want a positive value when we pull to the left. Xbox controllers
    // return positive values when you pull to the right by default.
    final var ySpeed =
        -m_yspeedLimiter.calculate(MathUtil.applyDeadband(m_controller.getLeftX(), 0.02))
            * Drivetrain.kMaxSpeed;

    // Get the rate of angular rotation. We are inverting this because we want a
    // positive value when we pull to the left (remember, CCW is positive in
    // mathematics). Xbox controllers return positive values when you pull to
    // the right by default.
    final var rot =
        -m_rotLimiter.calculate(MathUtil.applyDeadband(m_controller.getRightX(), 0.02))
            * Drivetrain.kMaxAngularSpeed;

    m_swerve.drive(xSpeed, ySpeed, rot, fieldRelative, getPeriod());
  }
}
/*Default disabledPeriodic() method... Override me!
Default robotPeriodic() method... Override me!
Unhandled exception: java.lang.NoSuchMethodError: 'org.ejml.simple.SimpleBase org.ejml.simple.SimpleMatrix.mult(org.ejml.simple.SimpleBase)'
Error at frc.robot.Subsystems.Drivetrain.drive(Drivetrain.java:70): Unhandled exception: java.lang.NoSuchMethodError: 'org.ejml.simple.SimpleBase org.ejml.simple.SimpleMatrix.mult(org.ejml.simple.SimpleBase)'
at edu.wpi.first.math.kinematics.SwerveDriveKinematics.toSwerveModuleStates(SwerveDriveKinematics.java:135)
at edu.wpi.first.math.kinematics.SwerveDriveKinematics.toSwerveModuleStates(SwerveDriveKinematics.java:159)
at frc.robot.Subsystems.Drivetrain.drive(Drivetrain.java:70)
at frc.robot.Robot.driveWithJoystick(Robot.java:56)
at frc.robot.Robot.teleopPeriodic(Robot.java:30)
at edu.wpi.first.wpilibj.IterativeRobotBase.loopFunc(IterativeRobotBase.java:348)
at edu.wpi.first.wpilibj.TimedRobot.startCompetition(TimedRobot.java:130)
at edu.wpi.first.wpilibj.RobotBase.runRobot(RobotBase.java:358)
at edu.wpi.first.wpilibj.RobotBase.startRobot(RobotBase.java:451)
at frc.robot.Main.main(Main.java:23) */