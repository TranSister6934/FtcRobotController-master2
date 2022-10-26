import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp_1", group="Iterative Opmode")

public class TeleOp_1 extends OpMode {

    Hardwaremap hm = new Hardwaremap();

    @Override
    public void init() {

        hm.Init_robot(hardwareMap);

    }

    public void init_loop() {

    }
    public void start() {

    }

    @Override
    public void loop() {

       hm.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }
}
