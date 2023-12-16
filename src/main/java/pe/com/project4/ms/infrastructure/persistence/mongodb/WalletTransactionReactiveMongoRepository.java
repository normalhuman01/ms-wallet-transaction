package pe.com.project4.ms.infrastructure.persistence.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.com.project4.ms.application.repository.WalletTransactionRepository;
import pe.com.project4.ms.domain.WalletTransaction;
import pe.com.project4.ms.infrastructure.persistence.model.WalletTransactionDao;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class WalletTransactionReactiveMongoRepository implements WalletTransactionRepository {

    private final IWalletTransactionReactiveMongoRepository walletTransactionReactiveMongoRepository;

    @Override
    public Mono<WalletTransaction> save(WalletTransaction walletTransaction) {
        return walletTransactionReactiveMongoRepository.save(new WalletTransactionDao(walletTransaction))
                .map(WalletTransactionDao::toWalletTransaction);
    }

}
