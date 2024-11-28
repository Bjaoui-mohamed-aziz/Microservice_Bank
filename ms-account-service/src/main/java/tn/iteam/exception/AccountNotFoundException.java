package tn.iteam.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException (String noAccountsFound) {
        super(noAccountsFound);
    }
}
