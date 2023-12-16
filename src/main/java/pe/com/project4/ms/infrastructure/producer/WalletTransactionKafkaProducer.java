package pe.com.project4.ms.infrastructure.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;

@Component
@Slf4j
public class WalletTransactionKafkaProducer {
    private final KafkaTemplate<String, SendMoneyEvent> kafkaTemplate;
    private final String topic;

    public WalletTransactionKafkaProducer(KafkaTemplate<String, SendMoneyEvent> kafkaTemplate, @Value("${spring.kafka.consumer.topic.name}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(SendMoneyEvent sendMoneyEvent) {
        log.debug("Producing message {}", sendMoneyEvent.toString());
        kafkaTemplate.send(topic, sendMoneyEvent);
    }

}
