import java.util.Properties;

class ProducerDemo{
    //create Producer properties - bootstrap.servers, security.protocol, key.serialzier, value.serializer
    //connect to server
    Properties properties = new Properties();
    properties.setProperty("","");
    //create Producer
    //-------------
    KafkaProducer <String,String> producer = new KafkaProducer<>(properties);
    //create ProducerRecord
    ProducerRecord<String,String> producerRecord = new ProducerRecord <> ("<topic>","<value>");
    //send data
    producer.send(producerRecord);

    //tell the procuder to send all data and block until done - synchronous
    producer.flush();
    //flush and close producer
    producer.close();

}

//determine the partition and offset the messages was sent using Callbacks
class ProducerDemoWithCallback{
    //......
    producer.send(producerRecord,new Callback (){
        //executed after a record is sent success/fail
        @Override
        public void onCompletion(RecordMetadata rm, Exception e){
            //metadata.topic()/partition()/offset()
        }   
    });

    //if you loop and send multiple messages, all go into one parttion -> StickyPartitioner
    //Above happens due to internal batching, one batch combining messages is sent and the next batch into other partition -> perf improvement
    
    //With keys, add key in producerRecord and same keys go to same partition
}