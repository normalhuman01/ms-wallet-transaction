package pe.com.project4.ms.application.repository;

import pe.com.project4.ms.domain.WalletTransaction;
import reactor.core.publisher.Mono;

public interface WalletTransactionRepository {
    Mono<WalletTransaction> save(WalletTransaction walletTransaction);
}
