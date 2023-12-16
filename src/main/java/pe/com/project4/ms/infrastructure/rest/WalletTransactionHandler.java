package pe.com.project4.ms.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;
import pe.com.project4.ms.infrastructure.producer.WalletTransactionKafkaProducer;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WalletTransactionHandler {

    private final WalletTransactionKafkaProducer walletTransactionKafkaProducer;

    public Mono<ServerResponse> postWalletTransaction(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(SendMoneyEvent.class)
                .map(sendMoneyEvent -> {
                    walletTransactionKafkaProducer.sendMessage(sendMoneyEvent);
                    return sendMoneyEvent;
                }).then(ServerResponse.noContent().build());
    }
}
