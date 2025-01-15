public class Account {
    private String accName;
    private String password;

    public Account(String accName, String password) {
        this.accName = accName;
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public String getAccName() {
        return this.accName;
    }

}