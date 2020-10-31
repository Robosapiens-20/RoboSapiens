package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "IntakeandShooter", group = "TestBot")
public class IntakeandShooter extends LinearOpMode {


    String shooter = "shooter";
    String intake = "intake";

    String mover = "mover";
    String wobble = "wobble";
    String wobble_motor = "wobble_motor";


    String FrontLeftMotor = "front_left";
    String FrontRightMotor = "front_right";
    String BackLefttMotor = "back_left";
    String BackRightMotor = "back_right";


    //  String turnArmName = "";

    //  Servo liftServo = hardwareMap.servo.get(liftServoName);


    DcMotor GoalShooter = null;
    DcMotor ringIntake = null;

    Servo pusher = null;
Servo wobbler = null;
DcMotor wobbler_motor = null;
    DcMotor frontLeft = null;
    DcMotor frontRight = null;
    DcMotor backLeft = null;
    DcMotor backRight = null;





    Gamepad g1 = gamepad1;


    @Override
    public void runOpMode() throws InterruptedException {
        String wobble = "wobble";
        String wobble_motor = "wobble_motor";

        String shooter = "shooter";
        String intake = "intake";

        String mover = "mover";
        String FrontLeftMotor = "front_left";
        String FrontRightMotor = "front_right";
        String BackLefttMotor = "back_left";
        String BackRightMotor = "back_right";

        frontLeft = hardwareMap.dcMotor.get(FrontLeftMotor);
        frontRight = hardwareMap.dcMotor.get(FrontRightMotor);
        backLeft = hardwareMap.dcMotor.get(BackLefttMotor);
        backRight = hardwareMap.dcMotor.get(BackRightMotor);


        GoalShooter = hardwareMap.dcMotor.get(shooter);
        ringIntake = hardwareMap.dcMotor.get(intake);
        pusher = hardwareMap.servo.get(mover);
        wobbler = hardwareMap.servo.get(wobble);
        wobbler_motor = hardwareMap.dcMotor.get(wobble_motor);

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);


        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);



        boolean currentStateOfT1 = false;
        boolean currentStateOfT2 = false;

        Gamepad g1 = gamepad1;
        Gamepad g2 = gamepad2;


        waitForStart();
        while (opModeIsActive()) {
            currentStateOfT1 = g2.left_bumper;
            currentStateOfT2 = g2.right_bumper;

            GoalShooter.setPower(-g2.right_trigger);
            GoalShooter.setPower(g2.left_trigger);
            ringIntake.setPower(-g2.left_stick_y);
            wobbler_motor.setPower(0.5*g2.right_stick_y);

            JoystickDrive(g1.left_stick_x,g1.left_stick_y,g1.right_stick_x,g1.right_stick_y);

            telemetry.addData("Shooter speed", GoalShooter.getPower());

            if (g2.a) {
                pusher.setPosition(0.3);
            }else{
                pusher.setPosition(0.55);
            }


            if(g2.left_bumper && currentStateOfT1 != false)
            {
                wobbler.setPosition(0.5);
            }
            if (g2.right_bumper && currentStateOfT2 != false){
                wobbler.setPosition(1);
            }


        }


    }


    public void JoystickDrive(double leftStickX, double leftStickY, double rightStickX, double rightStickY){
        double forward = leftStickY;
        double right = -leftStickX;
        double clockwise = -rightStickX;

        double frontLeft2 = (forward + clockwise + right);
        double frontRight2 = (forward - clockwise - right);
        double backLeft2 = (forward + clockwise - right);
        double backRight2 = (forward - clockwise + right);

        frontRight.setPower(-0.4*frontRight2);
        frontLeft.setPower(-0.4*frontLeft2);
        backRight.setPower(-0.4*backRight2);
        backLeft.setPower(-0.4*backLeft2);
    }

}



//      drop();
//this is for checking red
//  if (colorSensor.red() > 200 && colorSensor.blue() > 200 && colorSensor.green() > 200) {
//     setDirectionForward(false, 1000);
//   turn90(false,2000);
//turn90(true,500);
//setDirectionForward(true, 400);

//                if (colorSensor.red() > 200 && colorSensor.blue() > 200 && colorSensor.green() > 200) {
//                    setDirectionForward(false, 1000);
//                    turn90(false,500);
//                    turn90(true,500);
//                    setDirectionForward(true,400);
//
//                }
//                else if (colorSensor.red() > 200 && colorSensor.blue() < 100 && colorSensor.green() > 200) {
//                    setDirectionForward(true,400);
//
//                }
//            }-
//            else if (colorSensor.red() > 200 && colorSensor.blue() < 100 && colorSensor.green() > 200) {
//                setDirectionForward(true, 400);
//
//     }
//   }


