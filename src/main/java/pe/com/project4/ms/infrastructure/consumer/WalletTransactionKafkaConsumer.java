package pe.com.project4.ms.infrastructure.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.com.project4.ms.application.SaveWalletTransactionUseCase;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class WalletTransactionKafkaConsumer {

    private final SaveWalletTransactionUseCase saveWalletTransactionUseCase;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.name}", groupId = "TRANSACTION")
    public void consume(SendMoneyEvent sendMoneyEvent) {
        log.info("Consuming Message {}", sendMoneyEvent);
        saveWalletTransactionUseCase.save(sendMoneyEvent).subscribe(result -> log.debug(result.toString()));
    }

}
