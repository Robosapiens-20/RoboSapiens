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
Telemetry telemtry = new Telemetry() {
    @Override
    public Item addData(String caption, String format, Object... args) {
        return null;
    }

    @Override
    public Item addData(String caption, Object value) {
        return null;
    }

    @Override
    public <T> Item addData(String caption, Func<T> valueProducer) {
        return null;
    }

    @Override
    public <T> Item addData(String caption, String format, Func<T> valueProducer) {
        return null;
    }

    @Override
    public boolean removeItem(Item item) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void clearAll() {

    }

    @Override
    public Object addAction(Runnable action) {
        return null;
    }

    @Override
    public boolean removeAction(Object token) {
        return false;
    }

    @Override
    public void speak(String text) {

    }

    @Override
    public void speak(String text, String languageCode, String countryCode) {

    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public Line addLine() {
        return null;
    }

    @Override
    public Line addLine(String lineCaption) {
        return null;
    }

    @Override
    public boolean removeLine(Line line) {
        return false;
    }

    @Override
    public boolean isAutoClear() {
        return false;
    }

    @Override
    public void setAutoClear(boolean autoClear) {

    }

    @Override
    public int getMsTransmissionInterval() {
        return 0;
    }

    @Override
    public void setMsTransmissionInterval(int msTransmissionInterval) {

    }

    @Override
    public String getItemSeparator() {
        return null;
    }

    @Override
    public void setItemSeparator(String itemSeparator) {

    }

    @Override
    public String getCaptionValueSeparator() {
        return null;
    }

    @Override
    public void setCaptionValueSeparator(String captionValueSeparator) {

    }

    @Override
    public Log log() {
        return null;
    }
};
            if (g1.a) {
                pusher.setPosition(0.3);
            }else{

                pusher.setPosition(0.55);
            }


            if(g1.x)
            {
                wobble.setPosition(aa)
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


