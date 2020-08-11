package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class newGitTest extends LinearOpMode {
    DcMotor motor = null;
    DcMotor newmotor = null;
    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("front_right");
        newmotor = hardwareMap.dcMotor.get("front_left");

        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        newmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        motor.setPower(0);
        newmotor.setPower(0);
        waitForStart();
        motor.setPower(0);
        newmotor.setPower(0);
        while (opModeIsActive()){
            motor.setPower(1);
            delay(500);
            break;
        }

    }
    public void delay(double delayTime){
        double startTime = System.currentTimeMillis();
        boolean yee = true;
        while (System.currentTimeMillis() - startTime < delayTime){
            if (yee) {
                yee = false;
                telemetry.addData("Waiting for ", (System.currentTimeMillis() - startTime) + "/" + delayTime + " milliseconds");
            }
            telemetry.update();
        }
    }
}
