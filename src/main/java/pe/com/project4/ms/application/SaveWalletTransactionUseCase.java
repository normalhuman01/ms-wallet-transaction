package pe.com.project4.ms.application;

import pe.com.project4.ms.domain.WalletTransaction;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;
import reactor.core.publisher.Mono;

public interface SaveWalletTransactionUseCase {
    Mono<WalletTransaction> save(SendMoneyEvent sendMoneyEvent);
}
