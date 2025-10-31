package BankLedgerPro;

import java.time.Instant;
import java.util.UUID;

public class Transaction {
    UUID id;
    String accountId;
    Transaction type;
    double amount;
    String note;
    Instant timestamp;
}
