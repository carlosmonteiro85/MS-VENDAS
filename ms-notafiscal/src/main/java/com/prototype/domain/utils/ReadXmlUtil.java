package com.prototype.domain.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadXmlUtil {
	
	private static Document document = null; 

	public static Map<String, Object> readXml(String pathFile){

		Map<String , Object> parametros = new HashMap<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			document = factory.newDocumentBuilder().parse(pathFile);

			Element ide = bindTag("ide");
			Element emit = bindTag("emit");
			Element emitEnder = bindTag("enderEmit");
			Element dest = bindTag("dest");
			Element icmsTotal = bindTag("ICMSTot");
			Element transp = bindTag("transp");

			// logo
			parametros.put("Logo", "");
			parametros.put("SUBREPORT_DIR", "enderDest");

			// ide
			bindIde(parametros, ide);
			// emitente
			bindEmitente(parametros, emit);
			// endereco emitente
			bindEmitAdress(parametros, emitEnder);
			// destinatario 
			bindDestination(parametros, dest);
			// ICMS total
			bindIcmsTotal(parametros, icmsTotal);
			// frete / transportadora / volumes
			bindTransportadora(parametros, transp );

			//parametros.put("ISSQN_Total", veicTransp.getElementsByTagName("placa").item(0).getTextContent());
			//parametros.put("Trans_Placa", veicTransp.getElementsByTagName("placa").item(0).getTextContent());
			//parametros.put("xBairro", emitEnder.getElementsByTagName("xBairro").item(0).getTextContent());
			//parametros.put("xBairro", emitEnder.getElementsByTagName("xBairro").item(0).getTextContent());

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return parametros;
	}

	private static Element bindTag(String nameTag){
		return (Element) document.getElementsByTagName(nameTag).item(0);	
	}

	private static void bindIde(Map<String , Object> parametros, Element ide){
		parametros.put("NaturezaOperacao", ide.getElementsByTagName("natOp").item(0).getTextContent());
		parametros.put("FormaPagamento", ide.getElementsByTagName("indPag").item(0).getTextContent());
		parametros.put("Serie", ide.getElementsByTagName("serie").item(0).getTextContent());
		parametros.put("NumeroNF", ide.getElementsByTagName("nNF").item(0).getTextContent());
		parametros.put("DataEmissao", ide.getElementsByTagName("dEmi").item(0).getTextContent());
		parametros.put("Data_Saida", ide.getElementsByTagName("dSaiEnt").item(0).getTextContent());
		parametros.put("TipoNF", ide.getElementsByTagName("tpNF").item(0).getTextContent());
		parametros.put("Ambiente", ide.getElementsByTagName("tpAmb").item(0).getTextContent());
		parametros.put("Emissao", ide.getElementsByTagName("tpEmis").item(0).getTextContent());
		parametros.put("Chave", "");
		parametros.put("Protocolo", "");
		parametros.put("Versao", ide.getElementsByTagName("verProc").item(0).getTextContent());
	}

	private static void bindEmitente(Map<String , Object> parametros, Element emit){
		parametros.put("Emi_CNPJ", emit.getElementsByTagName("CNPJ").item(0).getTextContent());
		parametros.put("Emi_Nome", emit.getElementsByTagName("xNome").item(0).getTextContent());
		parametros.put("Emi_Fantasia", emit.getElementsByTagName("xFant").item(0).getTextContent());
		parametros.put("Emi_IE", emit.getElementsByTagName("IE").item(0).getTextContent());
		parametros.put("Emi_IEST", "");
		parametros.put("Emi_IM", "");
	}

	private static void bindEmitAdress(Map<String , Object> parametros, Element emitEnder){
		parametros.put("Emi_Logradouro", emitEnder.getElementsByTagName("xLgr").item(0).getTextContent());
		parametros.put("Emi_Numero", emitEnder.getElementsByTagName("nro").item(0).getTextContent());
		parametros.put("Emi_Bairro", emitEnder.getElementsByTagName("xBairro").item(0).getTextContent());
		parametros.put("Emi_Municipio", emitEnder.getElementsByTagName("xMun").item(0).getTextContent());
		parametros.put("Emi_UF", emitEnder.getElementsByTagName("UF").item(0).getTextContent());
		parametros.put("Emi_CEP", emitEnder.getElementsByTagName("CEP").item(0).getTextContent());
		parametros.put("Emi_Telefone", emitEnder.getElementsByTagName("fone").item(0).getTextContent());
	}

	private static void bindDestination(Map<String , Object> parametros, Element dest){
		parametros.put("Dest_CNPJ", dest.getElementsByTagName("CNPJ").item(0).getTextContent());
		parametros.put("Dest_CPF", dest.getElementsByTagName("CPF").item(0).getTextContent());
		parametros.put("Dest_Nome", dest.getElementsByTagName("xNome").item(0).getTextContent());
		parametros.put("Dest_IE", dest.getElementsByTagName("IE").item(0).getTextContent().trim());
		parametros.put("Dest_Logradouro", dest.getElementsByTagName("xLgr").item(0).getTextContent());
		parametros.put("Dest_Numero", dest.getElementsByTagName("nro").item(0).getTextContent());
		parametros.put("Dest_Complemento", dest.getElementsByTagName("xCpl").item(0).getTextContent());
		parametros.put("Dest_Bairro", dest.getElementsByTagName("xBairro").item(0).getTextContent());
		parametros.put("Dest_Municipio", dest.getElementsByTagName("cMun").item(0).getTextContent());
		parametros.put("Dest_UF", dest.getElementsByTagName("UF").item(0).getTextContent());
		parametros.put("Dest_CEP", dest.getElementsByTagName("CEP").item(0).getTextContent());
		parametros.put("Dest_Telefone", dest.getElementsByTagName("fone").item(0).getTextContent());
	}

	private static void bindIcmsTotal(Map<String , Object> parametros, Element icmsTotal){
		parametros.put("ValorBase", icmsTotal.getElementsByTagName("vBC").item(0).getTextContent());
		parametros.put("ValorICMS", icmsTotal.getElementsByTagName("vICMS").item(0).getTextContent());
		parametros.put("ValorBaseST", icmsTotal.getElementsByTagName("vBCST").item(0).getTextContent());
		parametros.put("ValorST", icmsTotal.getElementsByTagName("vST").item(0).getTextContent());
		parametros.put("ValorProdutos", icmsTotal.getElementsByTagName("vProd").item(0).getTextContent());
		parametros.put("ValorFrete", icmsTotal.getElementsByTagName("vFrete").item(0).getTextContent());
		parametros.put("ValorSeguro", icmsTotal.getElementsByTagName("vSeg").item(0).getTextContent());
		parametros.put("ValorDesconto", icmsTotal.getElementsByTagName("vDesc").item(0).getTextContent());
		parametros.put("ValorOutro", icmsTotal.getElementsByTagName("vOutro").item(0).getTextContent());
		parametros.put("ValorIPI", icmsTotal.getElementsByTagName("vIPI").item(0).getTextContent());
		parametros.put("ValorNF", icmsTotal.getElementsByTagName("vNF").item(0).getTextContent());
		parametros.put("ValorDesconto", icmsTotal.getElementsByTagName("vDesc").item(0).getTextContent());
	}

	private static void bindTransportadora(Map<String , Object> parametros, Element transp){
		parametros.put("Frete", transp.getElementsByTagName("modFrete").item(0).getTextContent());
		parametros.put("Trans_CNPJ", transp.getElementsByTagName("CNPJ").item(0).getTextContent());
		parametros.put("Trans_Nome", transp.getElementsByTagName("xNome").item(0).getTextContent());
		parametros.put("Trans_IE", transp.getElementsByTagName("IE").item(0).getTextContent());
		parametros.put("Trans_Endereco", transp.getElementsByTagName("xEnder").item(0).getTextContent());
		parametros.put("Trans_Municipio", transp.getElementsByTagName("xMun").item(0).getTextContent());
		parametros.put("Trans_UF", transp.getElementsByTagName("UF").item(0).getTextContent());
		parametros.put("Trans_Volumes", transp.getElementsByTagName("qVol").item(0).getTextContent());
		parametros.put("Trans_Especie", transp.getElementsByTagName("esp").item(0).getTextContent());
		parametros.put("Trans_Marca", transp.getElementsByTagName("marca").item(0).getTextContent());
		parametros.put("Trans_Numeracao", transp.getElementsByTagName("nVol").item(0).getTextContent());
		parametros.put("Trans_PesoB", transp.getElementsByTagName("pesoB").item(0).getTextContent());
		parametros.put("Trans_PesoL", transp.getElementsByTagName("pesoL").item(0).getTextContent());
		parametros.put("Trans_Placa", transp.getElementsByTagName("placa").item(0).getTextContent());
		parametros.put("Trans_PlacaUF", transp.getElementsByTagName("UF").item(0).getTextContent());
	}

	public static void main(String[] args) {

		String property = System.getProperty("user.dir");

		Map<String, Object> readXml = ReadXmlUtil.readXml(property + "/"+ "ms-notafiscal" +"/"+ "exemploDANDE.xml");

		System.out.println(readXml);


	}
}