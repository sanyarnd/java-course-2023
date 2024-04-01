package org.example.todolist.config;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.todolist.config.props.KafkaProducerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.example.todolist.avro.TaskInfoEvent;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, TaskInfoEvent> producerFactory(KafkaProducerProperties kafkaProducerProperties) {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerProperties.getBootstrapServers());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, kafkaProducerProperties.getClientId());
        props.put(ProducerConfig.ACKS_CONFIG, kafkaProducerProperties.getAcksMode());
        props.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, (int) kafkaProducerProperties.getDeliveryTimeout().toMillis());
        props.put(ProducerConfig.LINGER_MS_CONFIG, kafkaProducerProperties.getLingerMs());
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProducerProperties.getBatchSize());
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, kafkaProducerProperties.getMaxInFlightPerConnection());
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, kafkaProducerProperties.getEnableIdempotence());
        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProducerProperties.getSchemaRegistryUrl());
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, TaskInfoEvent> kafkaTemplate(ProducerFactory<String, TaskInfoEvent> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
