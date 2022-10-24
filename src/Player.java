import java.util.Scanner;

public class Player {
    public final String name;
    private Account account;
public Player(int playerNum){
    Scanner scanner = new Scanner(System.in);
    System.out.println(playerNum);
    this.name=scanner.nextLine();

}
public int getAccount() {
    return account.getBalance(); }
}

