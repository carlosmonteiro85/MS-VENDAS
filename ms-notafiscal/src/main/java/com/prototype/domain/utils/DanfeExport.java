package com.prototype.domain.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Slf4j
@Data
@Component
@RequiredArgsConstructor
public class DanfeExport {

	private final JasperReport reports;
	
	public void emitirDanfePdf(Map<String, Object> parametros, HttpServletResponse response) throws IOException {

		try {
			JasperPrint print = JasperFillManager.fillReport(reports, parametros);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(print, out);
			
			response.setContentType("application/pdf");
			// TODO precisa gerar nome dinâmico
			response.setHeader("Content-Disposition", "inline; filename=danfe.pdf");
			response.setContentLength(out.size());
			response.getOutputStream().write(out.toByteArray());

		} catch (JRException e) {
			log.error("Error ao emitir uma sw uma nota fiscal: {}", e.getMessage());
		}
	}
}
