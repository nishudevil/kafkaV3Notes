import java.time.Duration;

public class ConsumerDemo {
        //Consumers with same group read from mutually exclusive parttions

        //create Producer properties - bootstrap.servers, security.protocol, key.deserialzier, value.deserializer
        //StringSerializer.class/StringDeserializer.class, group.id, auto.offest.reset = none/earliest/latest
        //When a consumer joins a consumer group it will fetch the last committed offset so it will restart to read from 5, 6, 7 
        //if before crashing it committed the latest offset (so 4). The earliest and latest values for the 
        //auto.offset.reset property is used when a consumer starts but there is no committed offset for the assigned partition. 
        //In this case you can chose if you want to re-read all the messages from the beginning (earliest) [start from last committed offset] or 
        //just after the last one (latest) [start from the latest message sent by producer previous are lost since they were not committed].

        //create KafkaConsumer
        //subscribe to topic
        consumer.subscribe(Arrays.asList(topic));
        //poll for data
        while(true){
            //inifite polling
            CosnumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000)); // wait for 1 sec to get data->timeout
            //loop through each record ConsumerRecord*
        }

        //**Graceful Shutdown->consumer.wakeup() throughs WakeupException in next poll, catch it and consumer.close() finally - Lec.49
        //Start multiple instances of consumer and rebalancing of groups happen 
        //Always do clean shutdown* for rebalancing to happen properly

        //Moving partitions b/w cosnumers is called rebalance -> new Consumer/partiton
        //Eager Rebalance-> all consumers stop and then rejoin for new assignment-> short time processing doesn't happen e.g. RAnge Assignor, RoundRobin, StickyAssignor-> balanced RR minimizes partition movements
        //Cooperative Rebalance -> Reassign small subset of parttions from one conusmer to another, others are not interrupted
        //partition.assignment.strategy=CooperativeStickyAssignor
        
        //Static group membership -> assign group.instance.id to every consumer to make it static
        //rebalance will not happen till session.timeout.ms, and can rejoin when the consumer is back up, helpful in maintaining local state/cache

        //Auto commit offset enable.auto.commit=true
        //auto.commit.interval.ms -> poll()...poll()... when time elapses commitAsync() occurs after last successful poll() of batch

    
}
