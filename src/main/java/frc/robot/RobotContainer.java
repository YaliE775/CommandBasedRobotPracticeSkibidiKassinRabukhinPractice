package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.Tank;

public class RobotContainer {
    private final Tank tank;
    private final Joystick driverJoystick;

    public RobotContainer() {
        driverJoystick = new Joystick(JoystickConstants.DRIVER_PORT);

        tank = new Tank();
        
        tank.setDefaultCommand(new TankDriveCommand(tank, () -> driverJoystick.getRawAxis(1), () -> driverJoystick.getRawAxis(3)));
        configureBindings();
    }

    private void configureBindings() {}

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
