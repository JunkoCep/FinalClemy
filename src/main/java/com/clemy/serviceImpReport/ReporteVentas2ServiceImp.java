package com.clemy.serviceImpReport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clemy.commonsReport.JasperReportManager;
import com.clemy.enumsReport.TipoReporteEnum;
import com.clemy.modelo.ReporteVentasDTO;
import com.clemy.serviceReport.ReporteVentas2ServiceAPI;


import net.sf.jasperreports.engine.JRException;


@Service
public class ReporteVentas2ServiceImp implements ReporteVentas2ServiceAPI  {

	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;


	@Override
	public ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Ventas";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}
}