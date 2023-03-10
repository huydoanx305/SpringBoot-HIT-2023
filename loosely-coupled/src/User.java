public class User {

  private Phone phone;

  public User(Phone phone) {
    this.phone = phone;
  }

  public void getPhone() {
    phone.using();
  }
}
