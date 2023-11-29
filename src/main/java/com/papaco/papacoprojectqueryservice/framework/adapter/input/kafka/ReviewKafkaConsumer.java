package com.papaco.papacoprojectqueryservice.framework.adapter.input.kafka;

import com.papaco.avro.schema.ReviewMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReviewKafkaConsumer {
    @KafkaListener(
            topics = "${papaco.kafka.review.avro.topic.name}",
            groupId = "papaco-review-project-query",
            concurrency = "3")
    public void listenReview(ConsumerRecords<String, ReviewMessage> records, Consumer<String, String> consumer) {
        records.forEach(record -> log.info("consume record: {}", record.toString()));
        consumer.commitSync();
    }
}
