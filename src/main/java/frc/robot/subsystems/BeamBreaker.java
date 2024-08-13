package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BeamBreakerConstants;

public class BeamBreaker extends SubsystemBase {
    private final DigitalInput beamBreakIn;

    public BeamBreaker() {
        beamBreakIn = new DigitalInput(BeamBreakerConstants.BREAKER_PORT);
    }

    public boolean getBreakerState() {
        return beamBreakIn.get();
    }

    @Override
    public void periodic() {
        Logger.recordOutput("Beam Breaker State", getBreakerState());
        
    }
}
