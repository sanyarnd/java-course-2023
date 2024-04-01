package org.example.todolist.tasks.distributor.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("kafka.consumer")
public class KafkaConsumerProperties {

    private String bootstrapServers;
    private String groupId;
    private String autoOffsetReset;
    private Integer maxPollIntervalMs;
    private Boolean enableAutoCommit;
    private Integer concurrency;
    private String schemaRegistryUrl;
}
