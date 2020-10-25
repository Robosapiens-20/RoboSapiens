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

    //  String turnArmName = "";

    //  Servo liftServo = hardwareMap.servo.get(liftServoName);


    DcMotor GoalShooter = null;
    DcMotor ringIntake = null;

    Servo pusher = null;
Servo wobbler = null;
DcMotor wobbler_motor = null;




    Gamepad g1 = gamepad1;


    @Override
    public void runOpMode() throws InterruptedException {
        String wobble = "wobble";
        String wobble_motor = "wobble_motor";

        String shooter = "shooter";
        String intake = "intake";

        String mover = "mover";


        GoalShooter = hardwareMap.dcMotor.get(shooter);
        ringIntake = hardwareMap.dcMotor.get(intake);
        pusher = hardwareMap.servo.get(mover);
        wobbler = hardwareMap.servo.get(wobble);
        wobbler_motor = hardwareMap.dcMotor.get(wobble_motor);

        Gamepad g1 = gamepad1;


        waitForStart();
        while (opModeIsActive()) {



            GoalShooter.setPower(-gamepad1.right_trigger);
            ringIntake.setPower(-gamepad1.left_stick_y);
            wobbler_motor.setPower(gamepad1.right_stick_y);


            telemetry.addData("Shooter speed", GoalShooter.getPower());

            if (g1.a) {
                pusher.setPosition(0.3);
            }else{
                pusher.setPosition(0.55);
            }


            if(g1.x)
            {
                wobbler.setPosition(1);
            }
            else{
                wobbler.setPosition(0.5);
            }


        }


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


