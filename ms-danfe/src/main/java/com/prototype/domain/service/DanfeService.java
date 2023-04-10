package com.prototype.domain.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.prototype.api.controller.dto.DanfeDTO;
import org.springframework.stereotype.Service;

import com.prototype.domain.utils.DanfeExport;
import com.prototype.domain.utils.ReadXmlUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DanfeService {
	
	private final DanfeExport export;
	private final TesteService serice;

	public void gerarDanfe(HttpServletResponse response) {
		
		Map<String, Object> parametros = ReadXmlUtil.readXml(System.getProperty("user.dir") + "/"+ "exemploDANDE.xml");

		DanfeDTO dadosDanfe = new DanfeDTO();
		dadosDanfe.setNaturezaOperacao(parametros.get("NaturezaOperacao").toString());
		dadosDanfe.setFormaPagamento(parametros.get("FormaPagamento").toString());
		dadosDanfe.setSerie(parametros.get("Serie").toString());
		dadosDanfe.setNumeroNF(parametros.get("NumeroNF").toString());
		dadosDanfe.setDataEmissao(parametros.get("DataEmissao").toString());
		dadosDanfe.setDataSaida(parametros.get("Data_Saida").toString());
		dadosDanfe.setTipoNF(parametros.get("TipoNF").toString());
		dadosDanfe.setAmbiente(parametros.get("Ambiente").toString());
		dadosDanfe.setChave(parametros.get("Chave").toString());
		dadosDanfe.setProtocolo(parametros.get("Protocolo").toString());
		dadosDanfe.setVersao(parametros.get("Versao").toString());
		dadosDanfe.setEmitenteCnpj(parametros.get("Emi_CNPJ").toString());
		dadosDanfe.setEmitenteNome(parametros.get("Emi_Nome").toString());
		dadosDanfe.setEmitenteFantasia(parametros.get("Emi_Fantasia").toString());
		dadosDanfe.setEmitenteIe(parametros.get("Emi_IE").toString());
		dadosDanfe.setEmitenteIest(parametros.get("Emi_IEST").toString());
		dadosDanfe.setEmitenteIm(parametros.get("Emi_IM").toString());
		dadosDanfe.setEmitenteLogradouro(parametros.get("Emi_Logradouro").toString());
		dadosDanfe.setEmitenteNome(parametros.get("Emi_Numero").toString());
		dadosDanfe.setEmitenteBairro(parametros.get("Emi_Bairro").toString());
		dadosDanfe.setEmitenteMunicipio(parametros.get("Emi_Municipio").toString());
		dadosDanfe.setEmitenteUf(parametros.get("Emi_UF").toString());
		dadosDanfe.setEmitenteCep(parametros.get("Emi_CEP").toString());
		dadosDanfe.setEmitenteTelefone(parametros.get("Emi_Telefone").toString());

		dadosDanfe.setDestinatarioCnpj(parametros.get("Dest_CNPJ").toString());
		dadosDanfe.setDestinatarioCpf(parametros.get("Dest_CPF").toString());
		dadosDanfe.setDestinatarioNome(parametros.get("Dest_Nome").toString());
		dadosDanfe.setDestinatarioIe(parametros.get("Dest_IE").toString());
		dadosDanfe.setDestinatarioLogradouro(parametros.get("Dest_Logradouro").toString());
		dadosDanfe.setDestinatarioNumero(parametros.get("Dest_Numero").toString());
		dadosDanfe.setDestinatarioComplemento(parametros.get("Dest_Complemento").toString());
		dadosDanfe.setDestinatarioBairro(parametros.get("Dest_Bairro").toString());
		dadosDanfe.setDestinatarioMunicipio(parametros.get("Dest_Municipio").toString());
		dadosDanfe.setDestinatarioUf(parametros.get("Dest_UF").toString());
		dadosDanfe.setDestinatarioCep(parametros.get("Dest_CEP").toString());
		dadosDanfe.setDestinatarioTelefone(parametros.get("Dest_Telefone").toString());

		dadosDanfe.setValorBase(parametros.get("ValorBase").toString());
		dadosDanfe.setValorIcms(parametros.get("ValorICMS").toString());
		dadosDanfe.setValorBaseSt(parametros.get("ValorBaseST").toString());
		dadosDanfe.setValorSt(parametros.get("ValorST").toString());
		dadosDanfe.setValorProdutos(parametros.get("ValorProdutos").toString());
		dadosDanfe.setValorFrete(parametros.get("ValorFrete").toString());
		dadosDanfe.setValorSeguro(parametros.get("ValorSeguro").toString());
		dadosDanfe.setValorDesconto(parametros.get("ValorDesconto").toString());
		dadosDanfe.setValorOutro(parametros.get("ValorOutro").toString());
		dadosDanfe.setValorIpi(parametros.get("ValorIPI").toString());
		dadosDanfe.setValorNf(parametros.get("ValorNF").toString());
		dadosDanfe.setValorDesconto(parametros.get("ValorDesconto").toString());

		dadosDanfe.setFrete(parametros.get("Frete").toString());
		dadosDanfe.setTransporteCnpj(parametros.get("Trans_CNPJ").toString());
		dadosDanfe.setTransporteNome(parametros.get("Trans_Nome").toString());
		dadosDanfe.setTransporteIe(parametros.get("Trans_IE").toString());
		dadosDanfe.setTransporteEndereco(parametros.get("Trans_Endereco").toString());
		dadosDanfe.setTransporteMunicipio(parametros.get("Trans_Municipio").toString());
		dadosDanfe.setTransporteUf(parametros.get("Trans_UF").toString());
		dadosDanfe.setTransporteVolume(parametros.get("Trans_Volumes").toString());
		dadosDanfe.setTransporteEspecie(parametros.get("Trans_Especie").toString());
		dadosDanfe.setTransporteMarca(parametros.get("Trans_Marca").toString());
		dadosDanfe.setTransporteNumeracao(parametros.get("Trans_Numeracao").toString());
		dadosDanfe.setTransportePesoB(parametros.get("Trans_PesoB").toString());
		dadosDanfe.setTransportePesoL(parametros.get("Trans_PesoL").toString());
		dadosDanfe.setTransporteAntt(parametros.get("Trans_ANTT").toString());
		dadosDanfe.setTransportePlaca(parametros.get("Trans_Placa").toString());
		dadosDanfe.setTransportePlacaUf(parametros.get("Trans_PlacaUF").toString());

		dadosDanfe.setIssqnTotal(parametros.get("ISSQN_Total").toString());
		dadosDanfe.setIssqnBase(parametros.get("ISSQN_Base").toString());
		dadosDanfe.setIssqnValor(parametros.get("ISSQN_Valor").toString());

		dadosDanfe.setInformacoes(parametros.get("Informacoes").toString());

		try {
			byte[] bytes = serice.gerarRelatorioEmPDF(dadosDanfe);

			response.setContentType("application/pdf");
			// TODO precisa gerar nome dinâmico
			response.setHeader("Content-Disposition", "inline; filename=danfe.pdf");
			response.setContentLength(bytes.length);
			response.getOutputStream().write(bytes);



//			export.emitirDanfePdf(parametros, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
