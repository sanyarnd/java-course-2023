package tinkoff2.oop.classes.inner;

public class Person {
    private String name;
    private Account account;

    Person(String name, String password){
        this.name = name;
        account = new Account(password);
    }
    public void displayPerson(){
        System.out.printf("Person \t Name: %s \t Password: %s \n", name, account.password);
    }

    public Account getAccount() {
        return account;
    }

    public class Account{
        private String password;

        Account(String pass){
            this.password = pass;
        }
        void displayAccount(){
            System.out.printf("Account Login: %s \t Password: %s \n", Person.this.name, password);
        }
    }
}
