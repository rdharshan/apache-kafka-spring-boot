# Start ZooKeeper
bin\windows\zookeeper-server-start config\zookeeper.properties

# Start Broker
bin\windows\kafka-server-start config\server.properties

# Single Node-Single Broker Configuration
bin\windows\kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Hello-Kafka

# List of Topics
bin\windows\kafka-topics --list --zookeeper localhost:2181

# Start Producer to Send Messages
bin\windows\kafka-console-producer --broker-list localhost:9092 --topic Hello-Kafka

# Start Consumer to Receive Messages
bin\windows\kafka-console-consumer --bootstrap-server localhost:9092 -topic Hello-Kafka --from-beginning