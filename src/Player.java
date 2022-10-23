import java.util.Scanner;
public class Player {
    public final String name;
    private int currentBalance;
public Player(int playerNum){
    Scanner scanner = new Scanner(System.in);
    System.out.println(playerNum);
    this.name=scanner.nextLine();
    //test commit
}
public int getAccount() {
    // forstår ikke hvorfor den ikke 'kalder' på klassen Account
    return currentBalance; }
}

