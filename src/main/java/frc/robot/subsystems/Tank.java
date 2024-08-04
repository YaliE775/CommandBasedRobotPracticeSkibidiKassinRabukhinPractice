package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankConstants;

public class Tank extends SubsystemBase{
    private final TalonSRX rightMaster;
    private final TalonSRX leftMaster;

    private final TalonSRX rightSlave;
    private final TalonSRX leftSlave;

    public Tank() {
        rightMaster = new TalonSRX(TankConstants.MASTER_RIGHT_ID);
        leftMaster = new TalonSRX(TankConstants.MASTER_LEFT_ID);

        rightSlave = new TalonSRX(TankConstants.SLAVE_RIGHT_ID);
        leftSlave = new TalonSRX(TankConstants.SLAVE_LEFT_ID);

        rightSlave.follow(rightMaster);
        leftSlave.follow(leftMaster);

        rightMaster.setInverted(true);
        rightSlave.setInverted(true);

        leftMaster.setInverted(false);
        leftSlave.setInverted(false);

        rightMaster.setNeutralMode(NeutralMode.Brake);
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightSlave.setNeutralMode(NeutralMode.Brake);
        leftSlave.setNeutralMode(NeutralMode.Brake);
        
        
    }

    public void drive(DoubleSupplier rightAxis, DoubleSupplier leftAxis) {
        rightMaster.set(ControlMode.PercentOutput, rightAxis.getAsDouble());
        leftMaster.set(ControlMode.PercentOutput, leftAxis.getAsDouble());

    }


}
