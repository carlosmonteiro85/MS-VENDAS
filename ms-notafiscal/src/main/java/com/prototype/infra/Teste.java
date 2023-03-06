package com.prototype.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prototype.domain.model.DadosParaGeracaoDanfe;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class Teste {
	
	/*
	 * método que ira escutar a fila configurada 
	 * */
	@RabbitListener(queues = "${mq.queues.emissao-nf}")
	public void receberSolicitacaoEmissao(@Payload String payload) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			DadosParaGeracaoDanfe dados = mapper.readValue(payload, DadosParaGeracaoDanfe.class);
			
			// TODO enviar dados para a API que simulará a receta para a geração do XML
			// ler o xml para gerar os dados da Danfe.class
			// persistir a Danfe 
			// gerar o arquivo para download
			
		} catch (Exception e) {
			log.error("Error ao emitir uma sw uma nota fiscal: {}", e.getMessage());
		} 
	}

}
