package co.sys.generators.bna.export.participant;

import org.springframework.lang.Nullable;

public class Member extends User {

    @Nullable
    private Double balance;

    public Member(String email, String firstName, String lastName, Double balance) {
        super(email, firstName, lastName);
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Member(String email, String firstName, String lastName) {
        super(email, firstName, lastName);
    }
}
