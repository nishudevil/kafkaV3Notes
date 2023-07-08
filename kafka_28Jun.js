class kafkaCLINotes{

//CLI producer/consumer notes 
//kafka-topics.sh --command-config <fileName.config> --bootstrap-server localhost:9192

/*
#Topics
kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --create --topic first_topic
replicationFactor < brokers
default 1 parttion 1 replicationFactor

#Producer
produce into topics -> kafka-console-producer.sh --producer.config ......
--producer-property acks=all
Doesn't allow to publish to topic that doesn't exist, warning and autoCreate 
Edit server.properties to change num(partitions)

With key -> kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first_topic --property parse.key=true --property key.separator=:
--producer-property -> select strategy such that push 16KB into 1 partition then go to another, roundRobin most inefficent 

#Consume from tail/beginning/key from partition
--from-beginning -> not in order they were sent, ordering per partition
  Works only for the first time when group hasn't been created, post that reads only the latest offsets 
--property -> print.timestamp, print.key, print.value, print.partition 
--group -> consumers of same group read from diff partitions 
--producer into diff parttions -> consumer reading from diff
--even if consumer is stopped, it reads the messages produced from topic as it is of same group - CURRENT_OFFSET, LOG_END_OFFSET, LAG

#Consumer groups
kafka-consumer-groups.sh
--consumers commit offsets which allow them to restart the reads from where last commit happened
--reset-offsets --to-earliest -> consumer must be down inorder to reset -> reset the offsets to beginning of each partition -> read all messages again 

*/

//using conduktor UI platform
    
}
