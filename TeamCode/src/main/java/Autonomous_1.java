import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Autonomous_1", group = "blue")

public class Autonomous_1 extends OpMode {

    Hardwaremap hm = new Hardwaremap();
    private String auto_mode = "";

    @Override
    public void init() {

        hm.Init_robot(hardwareMap);

    }

    public void init_loop() {

        telemetry.addLine("Let's go!");

    }

    public void start() {

        resetRuntime();
        auto_mode = "drive_forward";

    }

    @Override
    public void loop() {

        switch (auto_mode) {

            case "drive_forward" :

                hm.drive(0.8,0.0,0.0);
                if (this.getRuntime() > 0.5) {
                    resetRuntime();
                    auto_mode = "stop";
                }

                break;

            case "drive_right" :

                hm.drive(-0.0,0.0,0.8);
            if (this.getRuntime() > 0.5) {
                    resetRuntime();
                    auto_mode = "drive_forward_2";
                }

                break;

            case "drive_forward_2" :

                hm.drive(0.8,0.0,0.0);
                if (this.getRuntime() > 0.4) {
                    resetRuntime();
                    auto_mode = "stop";
                }

                break;

            case "stop" :

                hm.drive(-0.0,0.0,0.0);

                resetRuntime();
                auto_mode = "";

                break;

            case "" :
                telemetry.addLine("Ta-da!!");

                break;


        }

    }
}
