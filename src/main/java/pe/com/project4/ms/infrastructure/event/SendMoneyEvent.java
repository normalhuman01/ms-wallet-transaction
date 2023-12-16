package pe.com.project4.ms.infrastructure.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.project4.ms.domain.WalletTransaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMoneyEvent {
    private String walletAccountSenderId;
    private String walletAccountReceiverId;
    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime occurredAt;

    public WalletTransaction toWalletTransaction() {
        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setWalletAccountSenderId(walletAccountSenderId);
        walletTransaction.setWalletAccountReceiverId(walletAccountReceiverId);
        walletTransaction.setAmount(amount);
        walletTransaction.setOccurredAt(occurredAt);
        return walletTransaction;
    }
}
