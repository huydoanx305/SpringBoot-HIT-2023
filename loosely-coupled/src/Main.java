public class Main {

  public static void main(String[] args) {

    IPhone iPhone = new IPhone();

    Samsung samsung = new Samsung();

    User user = new User(iPhone);
    user.getPhone();
  }

}
