package com.thuannd.export;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/export-service")
public class ExportTemplateController {

    @Autowired
    ArticleRepository articleRepo;

    @GetMapping("/home")
    public String viewReport() {
        return "home";
    }

    @GetMapping("/report")
    public String generateReport() {
        try{
            createReportPdf();
        }catch(JRException e){
            e.printStackTrace();
        }
        return "home";
    }

    public void createReportPdf() throws JRException {
        final InputStream stream = this.getClass().getResourceAsStream(Utils.REPORT_TEMPLATE);
        JasperReport report = JasperCompileManager.compileReport(stream);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(articleRepo.findAll());
        Map<String, Object> params = new HashMap<>();
        params.put("datasource", dataSource);
        final JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, Utils.REPORT_DESTFILE);
    }

}