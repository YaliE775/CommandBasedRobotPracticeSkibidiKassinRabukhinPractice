package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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

        rightMaster.setInverted(false);
        rightSlave.setInverted(false);

        leftMaster.setInverted(true);
        leftSlave.setInverted(true);

        rightMaster.setNeutralMode(NeutralMode.Brake);
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightSlave.setNeutralMode(NeutralMode.Brake);
        leftSlave.setNeutralMode(NeutralMode.Brake);

        rightSlave.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        leftSlave.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        
    }

    public void drive(DoubleSupplier rightAxis, DoubleSupplier leftAxis) {
        rightMaster.set(ControlMode.PercentOutput, rightAxis.getAsDouble());
        leftMaster.set(ControlMode.PercentOutput, leftAxis.getAsDouble());

    }

    @Override
    public void periodic() {
        Logger.recordOutput("Right Master Power", rightMaster.getMotorOutputPercent());
        Logger.recordOutput("Right Slave Power", rightSlave.getMotorOutputPercent());
        
        Logger.recordOutput("Left Master Power", leftMaster.getMotorOutputPercent());
        Logger.recordOutput("Left Slave Power", leftSlave.getMotorOutputPercent());


        Logger.recordOutput("Right Velocity", rightSlave.getSelectedSensorVelocity());

        Logger.recordOutput("Right Position", rightSlave.getSelectedSensorPosition());
        Logger.recordOutput("Left Position", leftSlave.getSelectedSensorPosition());


    }


}
