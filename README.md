# Avro Kafka Producer Spring Boot

### Build and Run Application

```shell
./gradlew clean build
./gradlew bootRun 
```

### Infrastructure

Import docker-compose from confluent

```shell
curl --silent --output docker-compose.yml \
https://raw.githubusercontent.com/obsidiandynamics/kafdrop/master/docker-compose/kafka-kafdrop/docker-compose.yaml
```

Run docker compose

```shell
docker-compose up -d
```

- kafka server: *localhost:9092*
- schema registry url: *http://localhost:8081*

Create topic:

- topic: *my-topic*

Create avro schema:

- avro schema: *src/main/avro/user-v1.avsc*

### Usage

Publish Avro message to topic:

```shell
curl --location --request GET 'localhost:8080/kafka/publish/HelloAvro'
```

### Reference Documentation

- https://docs.confluent.io/platform/current/quickstart/ce-docker-quickstart.html
- https://docs.confluent.io/platform/current/schema-registry/serdes-develop/serdes-avro.html
- https://docs.confluent.io/platform/current/schema-registry/develop/maven-plugin.html
- https://github.com/davidmc24/gradle-avro-plugin