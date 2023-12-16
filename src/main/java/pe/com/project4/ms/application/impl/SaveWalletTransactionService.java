package pe.com.project4.ms.application.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.project4.ms.application.SaveWalletTransactionUseCase;
import pe.com.project4.ms.application.repository.WalletTransactionRepository;
import pe.com.project4.ms.domain.WalletTransaction;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveWalletTransactionService implements SaveWalletTransactionUseCase {

    private final WalletTransactionRepository walletTransactionRepository;

    @Override
    public Mono<WalletTransaction> save(SendMoneyEvent sendMoneyEvent) {
        return walletTransactionRepository.save(sendMoneyEvent.toWalletTransaction());
    }

}
