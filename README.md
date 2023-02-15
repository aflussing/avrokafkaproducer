# Avro Kafka SSL Producer Spring Boot

### Setup

Get avro schema from schema registry and put it in src/main/avro/avro-schema.avsc
Change according to the schema the file src/main/java/com/example/avrokafkaproducer/controller/AvroKafkaProducerController.java

Put the proper kafka configuration properties in the application.properties file and put trustore.jks in resources folder

```properties
spring.kafka.ssl.trust-store-location=classpath:/truststore.jks
spring.kafka.ssl.trust-store-password=${truststore-password}
spring.kafka.bootstrap-servers=${kafa-server}
spring.kafka.properties.schema.registry.url=${schema-registry-url}
spring.kafka.producer.properties.sasl.jaas.config=org.apache.kafka.common.security.scram.ScramLoginModule required username=${avro-producer-user} password="${avro-producer-password}";
spring.kafka.template.default-topic=${avro-topic}
```


### Build and Run Application

```shell
./gradlew clean build
./gradlew bootRun 
```

### Usage

Publish Avro message to topic:

```shell
curl --location --request GET 'localhost:8080/kafka/publish'
```
