This file lists the main objects and some of their properties. You will normally declare the objects as global variables first, and then in the robotInit() method actually create and initialize the object.

Read the JavaDoc for these classes (see main page)

###:large_blue_diamond:Motors (Victor and Jaguar)
You have to know which port the motors are plugged into.

:boom:make a new motor object:
```Victor motor1 = new Victor(1);```

Other things to do with motor objects: `motor1.enableDeadbandElimination(true);`

###:large_blue_diamond:make a drive train
`RobotDrive driveTrain = new RobotDrive(motor1, motor2);`

`drivetrain.setSafetyEnabled(false);`	for autonomous mode (SimpleRobot)

`drivetrain.drive(speed, curve);`		Speed = -1.0 ó +1.0;  Curve is the same

`drivetrain.arcadeDrive(joystickLeft);`

`drivetrain.arcadeDrive(joystickLeft.getY(),joystickLeft.getX(),);`

`drivetrain.tankDrive(joystickLeft, joystickRight);`

`drivetrain.getLeftMotor().set(0.0);`  This shuts off the left motor

If your motor controllers are Jaguars, just use 1,2 – you don’t have to make a Jaguar object because they are the default.

If your motors are backwards, either change them in the RobotDrive constructor 
or `driveTrain.setInvertedMotor(motor1, true);`

###:large_blue_diamond:Joysticks

`Joystick joystickLeft = new Joystick(1);`	1st Joystick as seen in DriverStation Setup

`JoystickButton joyLeftBtn1 = new JoystickButton(joystickLeft, 1);`

`if (joyLeftBtn1.get()) { …}	//do something when button 1 is pressed`

####:large_blue_diamond:Other

:boom:`DigitalInput limitSwitch = new DigitalInput(5);`	//(channel)  (or module,channel)

:boom:Timers
(using the edu.wpi.first.wpilibj.Timer class -- not the util or swing timers)
`Timer.delay(0.1);`

`Timer armTimer = new Timer();`

`armTimer.start();`

`double time = armTimer.get();`

`armTimer.reset();`


Iterative Robot has a watchdog that must befed at a certain interval.
