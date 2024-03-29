package com.spring.userdept.kafka.producer.eventos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProdutorEvento {
	
	private final Producer<String, String> producer;

	public ProdutorEvento() {
		producer = criarProducer();
		
	}
	
	private Producer<String, String> criarProducer(){
		if(producer != null) {
		return producer;
		}
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializr");
		properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
		
		return new KafkaProducer<String, String>(properties);
	}
	
	public void executar() {
		
		/*criando UUID de chave única*/
		String chave = UUID.randomUUID().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/-MM-dd HH:mm:ss.SSS");
		String mensagem = sdf.format(new Date(0));
		mensagem += "|" + chave;
		mensagem += "|NOVA_MENSAGEM";
		
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("RegistroEvento", chave, mensagem);
		producer.send(record);
	}

	
}
