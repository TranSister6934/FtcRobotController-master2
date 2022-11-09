import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name="TeleOp_auto", group="Iterative Opmode")

public class TeleOp_auto extends OpMode {

    Hardwaremap hm = new Hardwaremap();
    int EV = 0;

    @Override
    public void init() {

        hm.Init_robot(hardwareMap);

        hm.BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hm.BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        hm.BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void init_loop() {

    }
    public void start() {

    }



    @Override
    public void loop() {

        if (gamepad1.dpad_up) {

            if (hm.BackLeft.getCurrentPosition() < 3000) {

                hm.BackLeft.setPower(0.5);
                EV = hm.BackLeft.getCurrentPosition();
                hm.BackLeft.setTargetPosition(EV);

            } else {
                hm.BackLeft.setPower(0);
            }

        } else if (gamepad1.dpad_down) {

            if (hm.BackLeft.getCurrentPosition() > 60) {

                hm.BackLeft.setPower(-0.5);

            } else {
                hm.BackLeft.setPower(0);
            }

        } else {
            hm.BackLeft.setPower(0.0);
        }


       //hm.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

       telemetry.addData("left Y", -gamepad1.left_stick_y);
       telemetry.addData("left X", gamepad1.left_stick_x);
       telemetry.addData("right X", gamepad1.right_stick_x);

        telemetry.addData("FrontRight", hm.BackLeft.getCurrentPosition());

        
    }
}
