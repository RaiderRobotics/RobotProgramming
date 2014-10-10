If you use the SimpleRobot base class, you'll only have one file.
Upon reflection, it probably isn't even worth learning SimpleRobot. Just proceed to IterativeRobot.

----

**:boom: Structure:**

:one:  you must have this package<br>
`package edu.wpi.first.wpilibj.templates;`

:two: Imports.<br>
```
//   import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
```

:three: main class extends base class<br>
`public class SimpleRobot1 extends SimpleRobot {`

:four: Declare global variables. Don’t initialize them here.
```
    Joystick joyLeft;
    RobotDrive chassis;
```

:five: Initialize variables in robotInit(). It’s safer to do this here than in a constructor.
```
   void robotInit() { 
      chassis = new RobotDrive(1,2);
      joyLeft = new Joystick(1);
   }    
```

:six: function for autonomous mode
```
    public void autonomous() {
        chassis.setSafetyEnabled(false);
        while(isAutonomous() && isEnabled()) {
	      chassis.drive(0.9,0.0);           
        }
    }
```

:seven: function for tele-op mode
```
    public void operatorControl() {
        chassis.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
	      chassis.arcadeDrive(joyLeft);
	      Timer.delay(0.01);
        }
    }
```

:eight: other functions (test mode, etc).<br>
Close main class

`}`

