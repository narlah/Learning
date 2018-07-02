package learnConcurency;

class Account {
    public int getBalance() {
        return balance;
    }

    private int balance = 10000;

    public void deposit(int a) {
        balance += a;
    }

    public void withdrawal(int a) {
        balance -= a;
    }

    public static void transfer(Account act1, Account act2, int amount) {
        act1.withdrawal(amount);
        act2.deposit(amount);
    }
}