
public class Bank {
    private double balance;

    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException("Invalid deposit amount: " + amount);
        }
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0 || amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal: " + amount);

        }
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(1000);

        try {
            bank.deposit(500);
            System.out.println("Balance after deposit: " + bank.getBalance());

            bank.withdraw(300);
            System.out.println("Balance after withdrawal: " + bank.getBalance());

            bank.withdraw(1800); // This will throw InsufficientBalanceException
        } catch (InvalidDepositException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    public class InvalidDepositException extends Exception {
        public InvalidDepositException(String message) {
            super(message);
        }
    }
}
