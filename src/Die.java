//Taget fra CDIO1
import java.util.Random;
public class Die {

    private int faceValue;
    private Random rng;

    //Construktur for Die class.

    public Die() {
        rng = new Random();
    }
    public void roll() {
        faceValue = rng.nextInt(6) + 1;
    }
    public int getFaceValue() {
        return faceValue;
    }
}