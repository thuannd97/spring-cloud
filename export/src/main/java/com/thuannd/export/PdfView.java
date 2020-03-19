package com.thuannd.export;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.web.servlet.view.AbstractView;

public class PdfView extends AbstractView {

    public PdfView() {
        setContentType("application/pdf");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        OutputStream byteOutput = createTemporaryOutputStream();
        Document document = newDocumemt();
        PdfWriter pdfWriter = newWriter(document, byteOutput, req);
        prepareWrite(model, pdfWriter, req);

        document.open();
        buildPdfDocument(model, document, pdfWriter, req, resp);
        document.close();

        wrtiteToResponse(resp, byteOutput);
    }

    private void wrtiteToResponse(HttpServletResponse resp, OutputStream byteOutput) {
    }

    private void buildPdfDocument(Map<String, Object> model, Document document,
            PdfWriter pdfWriter,
            HttpServletRequest req, HttpServletResponse resp) throws DocumentException {
        List<Article> data = (List<Article>) model.get("data");        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{2.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.CYAN);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("TITLE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("CONTENT", font));
        table.addCell(cell);

        table.completeRow();
        document.add(table);
        data.forEach(art ->{
            table.addCell(String.valueOf(art.getArticleId() != null ? art.getArticleId() : ""));
            table.addCell(String.valueOf(art.getTitle() != null ? art.getTitle() : ""));
            table.addCell(String.valueOf(art.getContent() != null ? art.getContent() : ""));
            table.completeRow();
        });         
        
    }

    @Override
    protected boolean generatesDownloadContent() {
        return false;
    }

    protected Document newDocumemt() {
        return new Document(PageSize.A4);
    }

    protected PdfWriter newWriter(Document document, OutputStream os, HttpServletRequest req) throws DocumentException {
        return PdfWriter.getInstance(document, os);
    }

    protected void prepareWrite(Map<String, Object> model, PdfWriter writer, HttpServletRequest req){
        writer.setViewerPreferences(getViewerPreferences());
    }

    protected int getViewerPreferences(){
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

}