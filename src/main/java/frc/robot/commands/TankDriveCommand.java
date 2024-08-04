package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tank;

public class TankDriveCommand extends Command{
    private final Tank tank;
    private DoubleSupplier rightAxis;
    private DoubleSupplier leftAxis;
    
    public TankDriveCommand(Tank tank, DoubleSupplier rightAxis, DoubleSupplier leftAxis) {
        this.tank = tank;
        this.rightAxis = rightAxis;
        this.leftAxis = leftAxis;
        addRequirements(tank);
    }

    @Override
    public void execute() {
        tank.drive(rightAxis, leftAxis);
    }
}
