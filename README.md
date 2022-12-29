# apache kafka client examples
Kafka client 原生API使用示例

# 部署启动Kafka
## 下载官方并解压安装包
```
> wget https://archive.apache.org/dist/kafka/2.1.1/kafka_2.12-2.1.1.tgz 
> tar zxvf kafka_2.12-2.1.1.tgz
```
   
## 使用默认配置启动Zookeper(localhost:2181)
```
> cd kafka_2.12-2.1.1
>./bin/zookeeper-server-start.sh -daemon ./config/zookeeper.properties
```
## 启动Kafka
```
> sed -i '32ilisteners=PLAINTEXT://[host]:9092' config/server.properties
> ./bin/kafka-server-start.sh -daemon ./config/server.properties
```
(Windows用户可以./bin/windows目录下的脚本)

# 验证消息发布、消费
## 创建Topic并查询
```
> bin/kafka-topics.sh --zookeeper localhost:2181 --create --topic my_topic --partitions 3 --replication-factor 1
> bin/kafka-topics.sh --list --zookeeper localhost:2181 
```
注：kafka 2.2.x版本及以上，执行如上命令时，建议用'--bootstrap-server localhost:9092'替代'--zookeeper localhost:2181'

## 发布消息
```
> bin/kafka-console-producer.sh --broker-list localhost:9092--topic my_topic
```
## 消费消息
```
> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my_topic --from-beginning
```
