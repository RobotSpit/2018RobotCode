package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.OI;
import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TC_Drive extends Command {

    public TC_Drive() {
        requires(Robot.kDRIVE);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kDRIVE.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Push encoders to dashboard
    	SmartDashboard.putNumber("RR Enc: ", Robot.kDRIVE.getEncoders()[0]);
    	SmartDashboard.putNumber("RF Enc: ", Robot.kDRIVE.getEncoders()[1]);
    	SmartDashboard.putNumber("LR Enc: ", Robot.kDRIVE.getEncoders()[2]);
    	SmartDashboard.putNumber("LF Enc: ", Robot.kDRIVE.getEncoders()[3]);
    	SmartDashboard.updateValues();
    	//Create a new mechanim drive instance
    	Robot.kDRIVE.mechDrive(OI.DriverStick.getY(Hand.kLeft), OI.DriverStick.getX(Hand.kLeft), OI.DriverStick.getX(Hand.kRight));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDRIVE.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
