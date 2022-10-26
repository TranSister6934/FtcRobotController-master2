import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardwaremap {
       //Constructor
    public Hardwaremap(){

    }



    public DcMotor FrontRight = null;
    public DcMotor FrontLeft = null;
    public DcMotor BackRight = null;
    public DcMotor BackLeft = null;

    HardwareMap hwMap = null;

    public void Init_robot(HardwareMap ahwMap) {

        hwMap = ahwMap;

        FrontRight = hwMap.dcMotor.get("FR");
        FrontLeft = hwMap.dcMotor.get("FL");
        BackRight = hwMap.dcMotor.get("BR");
        BackLeft = hwMap.dcMotor.get("BL");

        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void drive(double axial, double lateral, double yaw) {


        double max;



        double leftFrontPower  = axial + lateral + yaw;
        double rightFrontPower = axial - lateral - yaw;
        double leftBackPower   = axial - lateral + yaw;
        double rightBackPower  = axial + lateral - yaw;

        max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));

        if (max > 1.0) {
            leftFrontPower  /= max;
            rightFrontPower /= max;
            leftBackPower   /= max;
            rightBackPower  /= max;
        }


        FrontRight.setPower(rightFrontPower);
        FrontLeft.setPower(leftFrontPower);
        BackRight.setPower(rightBackPower);
        BackLeft.setPower(leftBackPower);

    }

}
