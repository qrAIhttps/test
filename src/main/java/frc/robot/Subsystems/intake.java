package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenixpro.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CONFIG.CONFIG;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;;
public class intake extends SubsystemBase {
    //public WPI_TalonFX  motor1 = new WPI_TalonFX(CONFIG.CANID.topLeftIntakeCANID)
    /** Creates a new ExampleSubsystem. */
    public intake() {}
  
    /**
     * Example command factory method.
     *
     * @return a command
     */
    public CommandBase exampleMethodCommand() {
      // Inline construction of command goes here.
      // Subsystem::RunOnce implicitly requires `this` subsystem.
      return runOnce(
          () -> {
            /* one-time action goes here */
          });
    }
  
    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
   // public boolean exampleCondition() {
      // Query some boolean state, such as a digital sensor.
    //  return false;
   // }
  
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }
  }