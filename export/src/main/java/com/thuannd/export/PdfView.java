package com.thuannd.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    public PdfView(final int a) {
        setContentType("application/pdf");
    }

    @Override
    protected void renderMergedOutputModel( Map<String, Object> model,HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        ByteArrayOutputStream byteOutput = createTemporaryOutputStream();
        Document document = newDocument();
        PdfWriter pdfWriter = newWriter(document, byteOutput, req);
        prepareWrite(model, pdfWriter, req);

        document.open();
        buildPdfDocument(model, document);
        document.close();

        wrtiteToResponse(resp, byteOutput);
    }

    private void wrtiteToResponse(HttpServletResponse resp, ByteArrayOutputStream byteOutput) {
        try {
            resp.getOutputStream().write(byteOutput.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildPdfDocument(Map<String, Object> model, Document document) throws DocumentException {
        final List<Article> data = (List<Article>) model.get("data");        
        final PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{2.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
        final Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        final PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.CYAN);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("TITLE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("CONTENT", font));
        table.addCell(cell);

        table.completeRow();
        data.forEach(art ->{
            table.addCell(String.valueOf(art.getArticleId() != null ? art.getArticleId() : ""));
            table.addCell(String.valueOf(art.getTitle() != null ? art.getTitle() : ""));
            table.addCell(String.valueOf(art.getContent() != null ? art.getContent() : ""));
            table.completeRow();
        });         
        document.add(table);
    }

    @Override
    protected boolean generatesDownloadContent() {
        return false;
    }

    protected Document newDocument() {
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