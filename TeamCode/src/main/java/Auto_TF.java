import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Auto_TF", group = "Tests")
public class Auto_TF extends OpMode {

    Hardwaremap hm = new Hardwaremap();
    TensorFlow_Class tf = new TensorFlow_Class();
    private String auto_mode = "";
    private int mode = 0;

    @Override
    public void init() {

        hm.Init_robot(hardwareMap);

        tf.initVuforia(hardwareMap);
        tf.initTfod(hardwareMap);

    }

    @Override
    public void init_loop() {

        tf.TF_read();

        telemetry.addData("label " , tf.Label);



    }

    @Override
    public void start() {

        resetRuntime();
        if ( tf.Label == "1 Bolt"){
            auto_mode = "drive_1";
            mode = 1;
        }

        resetRuntime();
        if ( tf.Label == "2 Bulb"){
            auto_mode = "drive_2";
            mode = 1;
        }

        resetRuntime();
        if ( tf.Label == "3 Panel"){
            auto_mode = "drive_3";
            mode = 1;
        }

    }

    @Override
    public void loop() {

        switch (auto_mode) {

            case "drive_1" :

                switch (mode) {

                    case 1 :

                        hm.drive(0.8,0.0,0.0);
                        if (this.getRuntime() > 0.32) {
                            resetRuntime();
                            mode = 2;
                        }

                        break;

                    case 2 :

                        hm.drive(-0.0,0.0,0.0);
                        if (this.getRuntime() > 0.5) {
                            //resetRuntime();
                            mode = 3;
                        }

                        break;

                    case 3 :

                        hm.drive(-0.0,-0.8,0.0);
                        if (this.getRuntime() > 1.3) {
                            //resetRuntime();
                            mode = 0;
                            auto_mode = "stop";
                        }

                        break;

                }



                break; //break for auto mode

            case "drive_2" :

                switch (mode) {

                    case 1 :

                        hm.drive(0.8,0.0,0.0);
                        if (this.getRuntime() > 0.32) {
                            resetRuntime();
                            mode = 0;
                            auto_mode = "stop";
                        }

                        break;

                }

                break; //break for auto mode

            case "drive_3" :

                switch (mode) {

                    case 1 :

                        hm.drive(0.8,0.0,0.0);
                        if (this.getRuntime() > 0.32) {
                            resetRuntime();
                            mode = 2;
                        }

                        break;

                    case 2 :

                        hm.drive(-0.0,0.0,0.0);
                        if (this.getRuntime() > 0.5) {
                            //resetRuntime();
                            mode = 3;
                        }

                        break;

                    case 3 :

                        hm.drive(-0.0,0.8,0.0);
                        if (this.getRuntime() > 1.0) {
                            //resetRuntime();
                            mode = 3;
                            auto_mode = "stop";
                        }

                        break;


                }

                break; //break for auto mode

            case "stop" :

                hm.drive(-0.0,0.0,0.0);
                //resetRuntime();
                auto_mode = "";

                break;

            case "" :
                telemetry.addLine("Ta-da!!");

                break;


        }

        telemetry.addData(" label " , tf.Label);

    }


}
