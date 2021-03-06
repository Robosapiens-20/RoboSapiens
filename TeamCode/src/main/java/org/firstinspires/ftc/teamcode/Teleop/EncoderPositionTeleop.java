package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "EncoderTeleop", group = "TestBot")
public class EncoderPositionTeleop extends LinearOpMode {

    // String liftServoName = "lift_servo";

    String FrontLeftMotor = "front_left";
    String FrontRightMotor = "front_right";
    String BackLefttMotor = "back_left";
    String BackRightMotor = "back_right";
    String AutoServoName = "auto_servo";
    String LinearSlideName = "linear_slide";
    String LeftCollectorName = " left_collector";
    String RightCollectorName = "right_collector";
    String RotationServoName = "rotationservo";
    String grabberName = "grabbername";
    String foundation1name = "left_foundation";
    String foundation2name = "right_foundation";
    //  String turnArmName = "";

    //  Servo liftServo = hardwareMap.servo.get(liftServoName);


    // DcMotor yee = null;
    DcMotor frontLeft = null;
    DcMotor frontRight = null;
    DcMotor backLeft = null;
    DcMotor backRight = null;
    boolean previousState = false;
    Servo AutoServo = null;
    DcMotor LeftCollector = null;
    DcMotor RightCollector = null;
    Servo Grabber = null;
    Servo Rotation = null;DcMotor LinearSlide = null;

    Servo foundationone = null;
    Servo foundationtwo = null;
    Servo minipinch = null;
    boolean currentStateofA1 = false;
    boolean currentStateofB2 = false;
    boolean currentStateofA = false;
    boolean currentStateofB = false;
    boolean currentStateofX = false;
    boolean currentStateofY = false;
    boolean currentStateofBumpersl = false;
    boolean currentStateofBumpers2 = false;
    boolean currentStateofBumpersFoundationOne = false;
    boolean currentStateofBUmpersFoundationTo = false;
    boolean currentStateofUp2 = false;
    boolean currentStateofRight2 = false;
    boolean currentStateofLeft2 = false;
    boolean currentStateJoystickButton1 = false;
    boolean currentStateJoystickButton2 = false;

    //  boolean currentStateofY = false;
    //   DcMotor liftMotor = null;
    // DcMotor turnArm = null;

    //   Gamepad g1 = gamepad1;
    // Gamepad g2 = gamepad2;

    int initialPositionL = 0;
    int initialPositionR = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        //String liftServoName = "lift_servo";


        //   String motorName = "yee";
        String FrontLeftMotor = "front_left";
        String FrontRightMotor = "front_right";
        String BackLefttMotor = "back_left";
        String BackRightMotor = "back_right";
        String AutoServoName = "auto_servo";
        String LinearSlideName = "linear_slide";
        String LeftCollectorName = " left_collector";
        String RightCollectorName = "right_collector";
        String RotationServoName = "rotationservo";
        String grabberName = "grabbername";
        String foundation1name = "left_foundation";
        String foundation2name = "right_foundation";
        String minipinchName = "pinch2";
        //      String liftMotorName = "lift_motor";
        //    String turnArmName = "turn_arm";
        //     Servo liftServo = hardwareMap.servo.get(liftServoName);


        //      yee = hardwareMap.dcMotor.get(motorName);
        frontLeft = hardwareMap.dcMotor.get(FrontLeftMotor);
        frontRight = hardwareMap.dcMotor.get(FrontRightMotor);
        backLeft = hardwareMap.dcMotor.get(BackLefttMotor);
        backRight = hardwareMap.dcMotor.get(BackRightMotor);
        AutoServo = hardwareMap.servo.get(AutoServoName);
        LinearSlide = hardwareMap.dcMotor.get(LinearSlideName);
        LeftCollector = hardwareMap.dcMotor.get(LeftCollectorName);
        RightCollector = hardwareMap.dcMotor.get(RightCollectorName);
        Rotation = hardwareMap.servo.get(RotationServoName);
        Grabber = hardwareMap.servo.get(grabberName);
        foundationone = hardwareMap.servo.get(foundation1name);
        foundationtwo = hardwareMap.servo.get(foundation2name);
        minipinch = hardwareMap.servo.get(minipinchName);
        Gamepad g1 = gamepad1;
        Gamepad g2 = gamepad2;
        LeftCollector.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        //br = 4659  fr=1658  fl = 4569 bl = 1966
        //= hardwareMap.dcMotor.get(liftMotorName);
        //       DcMotor turnArm = hardwareMap.dcMotor.get(turnArmName);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        LeftCollector.setPower(0);
        waitForStart();
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        LeftCollector.setPower(0);
//        while (opModeIsActive()) {
//            if (g1.left_stick_button != false)
//            {
//
//
//            }
//frontRight.setTargetPosition(3000);

            currentStateJoystickButton1 = g1.left_stick_button;
            currentStateJoystickButton2 = g1.right_stick_button;
            currentStateofA1 = g1.a;
            currentStateofB2 = g1.b;
            currentStateofA = g2.a;
            currentStateofB = g2.b;
            currentStateofX = g1.x;
            currentStateofLeft2 = g1.dpad_left;
            currentStateofRight2 = g1.dpad_right;
            currentStateofUp2 = g1.dpad_up;
            currentStateofBumpersFoundationOne = g1.left_bumper;
            currentStateofBUmpersFoundationTo = g1.right_bumper;
            currentStateofBumpersl = g2.dpad_left;
            currentStateofBumpers2 = g2.dpad_right;
            boolean currentStateofDPadUp = g2.dpad_up;
            currentStateofY = g1.y;
            JoystickDrive(gamepad1.left_stick_x,gamepad1.left_stick_y,gamepad1.right_stick_x,gamepad1.right_stick_y);
            //           yee.setPower(gamepad1.left_stick_y);
//            frontLeft.setPower(-gamepad1.left_stick_y);
//            frontRight.setPower(gamepad1.right_stick_y);
//            backLeft.setPower(-gamepad1.left_stick_y);
//            backRight.setPower(gamepad1.right_stick_y);

//            frontLeft.setPower(gamepad1.left_stick_x);
//            frontRight.setPower(gamepad1.right_stick_x);
//            backRight.setPower(-gamepad1.left_stick_x);
//            backLeft.setPower(-gamepad1.right_stick_x);
            LinearSlide.setPower(gamepad2.left_trigger);
            LinearSlide.setPower(gamepad2.right_trigger);
            RightCollector.setPower(gamepad2.right_stick_y);
            LeftCollector.setPower(-gamepad2.left_stick_y);
            foundationone = hardwareMap.servo.get(foundation1name);
            foundationtwo = hardwareMap.servo.get(foundation2name);
            telemetry.addData("arm motor position", LeftCollector.getCurrentPosition());


            telemetry.addData("back right: ", backRight.getCurrentPosition());
            telemetry.addData("front right : ", frontRight.getCurrentPosition());
            telemetry.addData("front left: ", frontLeft.getCurrentPosition());



            telemetry.addData("back right power:",backRight.getPower());
            telemetry.addData("front right power:",frontRight.getPower());
            telemetry.addData("back left power:",backLeft.getPower());
            telemetry.addData("front left power:",frontLeft.getPower());
            telemetry.update();
            while (g1.right_trigger ==1){
                double forward = -g1.left_stick_y;
                double right = g1.left_stick_x;
                double clockwise = g1.right_stick_x;

                double frontLeft2 = (forward - clockwise + right);
                double frontRight2 = (forward + clockwise - right);
                double backLeft2 = (forward - clockwise - right);
                double backRight2 = (forward + clockwise + right);

                frontRight.setPower(-0.6*frontRight2);
                frontLeft.setPower(-0.6*frontLeft2);
                backRight.setPower(-0.6*backRight2);
                backLeft.setPower(-0.6*backLeft2);
            }
            if (g1.a && currentStateofA1 != false) {
                AutoServo.setPosition(0.6);
            }
            if (g1.b && currentStateofB2 != false) {
                AutoServo.setPosition(0.95);
            }
            if (g1.x && currentStateofX != false) {
                AutoServo.setPosition(0);
            }
            if (g2.a && currentStateofA != false) {
                Rotation.setPosition(0.55);
            }
            if (g2.b && currentStateofB != false)
            {
                Rotation.setPosition(0.16);
            }

            if (g2.dpad_left && currentStateofBumpersl != false) {
                Grabber.setPosition(0);


            }
            if (g2.dpad_right && currentStateofBumpers2 != false) {
                Grabber.setPosition(1);

            }
            if (g2.dpad_up && currentStateofDPadUp != false) {
                Grabber.setPosition(0.5);
            }
            if (g1.dpad_left && currentStateofLeft2 != false) {
                minipinch.setPosition(0);


            }
            if (g1.dpad_right && currentStateofRight2 != false) {
                minipinch.setPosition(1);

            }
            if (g1.dpad_up && currentStateofUp2 != false) {
                minipinch.setPosition(0.5);
            }
            if (g1.left_bumper && currentStateofBumpersFoundationOne != false) {

                foundationtwo.setPosition(1);
                foundationone.setPosition(0 );
            }
            if(g1.right_bumper && currentStateofBUmpersFoundationTo != false ){
                foundationtwo.setPosition(0.75);
                foundationone.setPosition(0.35);
            }

        }




    public void encoderdrive(int frontleft, int frontright, int backleft, int backright)
    {

        frontRight.setTargetPosition(frontright);
        frontLeft.setTargetPosition(frontleft);
        backRight.setTargetPosition(backright);
        backLeft.setTargetPosition(backleft);
    }



    public void JoystickDrive(double leftStickX, double leftStickY, double rightStickX, double rightStickY){
        double forward = leftStickY;
        double right = -leftStickX;
        double clockwise = -rightStickX;

        double frontLeft2 = (forward + clockwise + right);
        double frontRight2 = (forward - clockwise - right);
        double backLeft2 = (forward + clockwise - right);
        double backRight2 = (forward - clockwise + right);

        frontRight.setPower(-0.6*frontRight2);
        frontLeft.setPower(-0.6*frontLeft2);
        backRight.setPower(-0.6*backRight2);
        backLeft.setPower(-0.6*backLeft2);
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


