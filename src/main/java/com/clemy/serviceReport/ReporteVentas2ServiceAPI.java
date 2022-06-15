package com.clemy.serviceReport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.clemy.modelo.ReporteVentasDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteVentas2ServiceAPI {
	
	ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;
}
