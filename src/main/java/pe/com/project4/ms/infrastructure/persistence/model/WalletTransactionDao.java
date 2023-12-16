package pe.com.project4.ms.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.project4.ms.domain.WalletTransaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("walletTransactions")
public class WalletTransactionDao {
    @Id
    private String id;
    private String walletAccountSenderId;
    private String walletAccountReceiverId;
    private BigDecimal amount;
    private LocalDateTime occurredAt;


    public WalletTransactionDao(WalletTransaction walletTransaction) {
        id = walletTransaction.getId();
        walletAccountSenderId = walletTransaction.getWalletAccountSenderId();
        amount = walletTransaction.getAmount();
        occurredAt = walletTransaction.getOccurredAt();
    }

    public WalletTransaction toWalletTransaction() {
        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setWalletAccountSenderId(walletAccountSenderId);
        walletTransaction.setWalletAccountReceiverId(walletAccountReceiverId);
        walletTransaction.setAmount(amount);
        walletTransaction.setOccurredAt(occurredAt);
        return walletTransaction;
    }

}
