/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

public class BasicRobot extends IterativeRobot {

    final static int ARCADE = 1;
    final static int TANK = 2;

    //create objects references
    Joystick stickL, stickR;
    RobotDrive chassis;
    Victor motor1, motor2;
   // JoystickButton stickLBtn1, stickLBtn2;

    //global variables
    private int driveState = ARCADE;

    public void robotInit() {
        motor1 = new Victor(1);
        motor2 = new Victor(2);
        chassis = new RobotDrive(motor1, motor2);
        stickL = new Joystick(1);
        stickR = new Joystick(2);
//		stickLBtn1 = new JoystickButton(stickL, 1);
//		stickLBtn2 = new JoystickButton(stickL, 2);
    }

    public void teleopInit() {
        Watchdog.getInstance().feed();
        //chassis.setSafetyEnabled(false);
    }

    // called at 50Hz (every 20ms).
    public void teleopPeriodic() {
        // feed the watchdog
        Watchdog.getInstance().feed();

        // drive the robot        
        if (driveState == ARCADE) {
            chassis.arcadeDrive(stickL);
        } else {
            chassis.tankDrive(stickL, stickR);
        }

        //check for button press to switch mode. Use two buttons to prevent bounce.
//		if (joyLeftBtn1.get()) driveState = ARCADE;
//		if (joyLeftBtn2.get()) driveState = TANK;
        //Since joystick button is not loaded ....
        boolean button1 = stickL.getRawButton(1);
        boolean button2 = stickL.getRawButton(2);
        if (button1) {
            driveState = ARCADE;
        }
        if (button2) {
            driveState = TANK;
        }

    }

    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
    }

    public void autonomousDisabled() {
    }
}

/**
 * ******
 * IterativeRobot
 *
 * The IterativeRobot class works differently than the SimpleRobot. It has a
 * number of overridable methods that are called over and over while the robot
 * is in one of three states: disabled, autonomous, or teleop.
 *
 * For each state there are three methods that are called, an init method, a
 * periodic method and a continuous method.
 *
 * Init methods (disabledInit, autonomousInit, teleopInit)
 *
 * Called when the corresponding state is first entered. It is possible that the
 * method will be called multiple times depending on the field controls. For
 * example, in some games there is a period between the autonomous and teleop
 * parts of the match were the robots are temporarily disabled while some
 * scoring function happens. This is where you should put your initialization
 * code.
 *
 * Periodic methods (disabledPeriodic, autonomousPeriodic, teleopPeriodic)
 *
 * These are called with each driver station update, approximately every 20 mS.
 * The idea is to put code here that gets values from the driver station and
 * updates the motors. You can read the joysticks and other driverstation inputs
 * more often, but you’ll only get the previous value until a new update is
 * received. By synchronizing with the received updates your program will put
 * less of a load on the cRIO CPU leaving more time for other tasks such as
 * camera processing.
 *
 * Continuous methods (disabledContinuous, autonomousContinuous,
 * teleopContinuous)
 *
 * These methods are called continuously during time the other methods are not
 * being called. Using the continuous methods can easily load down the CPU and
 * prevent other code from running properly, so should be used sparingly.
 *
 * With the Iterative robot your program is organized such that during each call
 * the state of the robot is advanced. For example, if the robot is to drive in
 * a square pattern during the autonomous period, then during each
 * autonomousPeriodic method call the program would keep track of which part of
 * the square it is currently drawing and if it should advance to the next part.
 *
 * http://www.604robotics.com/wordpress/wp-content/uploads/2012/09/WPI-Robotics-Library-Users-Guide.pdf
 * wiki.team1640.com/images/3/3b/IntroProgrammingFRCRobots2012.pdf
 *
 ******
 */
