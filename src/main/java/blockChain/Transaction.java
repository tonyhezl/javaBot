package blockChain;

public class Transaction {
    public String sender;
    public String recipient;
    public int amount;

    public Transaction(String sender, String recipient, int amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }
}

