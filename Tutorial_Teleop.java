package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Tutorial Teleop", group = "TestBot")
public class Tutorial_Teleop extends LinearOpMode {
    DcMotor frontRight = null;
    DcMotor frontLeft = null;
    DcMotor backLeft = null;
    DcMotor backRight = null;

    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("front_right");
        frontLeft = hardwareMap.dcMotor.get("front_left");
        backLeft = hardwareMap.dcMotor.get("back_left");
        backRight = hardwareMap.dcMotor.get("back_right");


        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);


        waitForStart();


    }

    public void turn(boolean value, double time, double powerL, double powerR) {
        double startTime = System.currentTimeMillis();
        if (value) {
            telemetry.addData("Turning Right", "Good Job");
            telemetry.update();
            backRight.setDirection(DcMotor.Direction.REVERSE);
            frontLeft.setDirection(DcMotor.Direction.FORWARD);
            frontRight.setDirection(DcMotor.Direction.REVERSE);
            backLeft.setDirection(DcMotor.Direction.FORWARD);

            telemetry.update();
            backLeft.setPower(powerL);
            backRight.setPower(powerR);
            frontLeft.setPower(powerL);
            frontRight.setPower(powerR);
            while (opModeIsActive()) {
                if ((System.currentTimeMillis() - startTime) >= time) {
                    backLeft.setPower(0);
                    backRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
                    break;
                }
            }
        } else {
            //initialPositionL = backLeft.getCurrentPosition();
            telemetry.addData("Turning Left", "Good Job");
            telemetry.update();
            backLeft.setDirection(DcMotor.Direction.REVERSE);
            frontRight.setDirection(DcMotor.Direction.FORWARD);
            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            backRight.setDirection(DcMotor.Direction.FORWARD);

            backLeft.setPower(powerL);
            backRight.setPower(powerR);
            frontLeft.setPower(powerL);
            frontRight.setPower(powerR);
            while (opModeIsActive()) {
                if ((System.currentTimeMillis() - startTime) >= time) {
                    backLeft.setPower(0);
                    backRight.setPower(0);
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
                    break;


                }
            }
        }
    }
}


