package BaseFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;


public class GeneratePDFReport {
  static  Document document;
	public static Document openPDF(String path) throws Exception, MalformedURLException, IOException {
		document = new Document();
		 
		
		

      
        
		try {
			PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream(path));
			 HeaderFooterPageEvent event = new HeaderFooterPageEvent();
			 OuterBorderEvent borderEvent = new OuterBorderEvent();
			 HeaderFooter image = new HeaderFooter();
	            
	            // Step 4: Set the event handler to the PdfWriter
	            writer.setPageEvent(image);
	            writer.setPageEvent(borderEvent);
	         writer.setPageEvent(event);
			document.open();
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
		
	}
	
public static Paragraph addParagraph(String comments) {
	 
	 Paragraph pg=null;
	 // Set the text color for the paragraph
     Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLUE); // Adjust the color as needed

     // Add text to the paragraph with the specified color
     
	
	 try {
		pg=new Paragraph();
		 pg.setAlignment(Paragraph.ALIGN_BASELINE);
		 pg.add(new Chunk(comments, font));
		 document.add(pg);
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pg;
	
}
public static void addScreenshot(String image) throws Exception {
	  try {
		  float width=width();
		  float Height=Height();
		Image img=Image.getInstance(image);
		//img.scaleToFit(width, Height);
		img.scaleToFit(730,740);
		document.add(img);
	} catch (BadElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void closeDocument() {
	document.close();
}
  
public static float width() {
	float documentWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
	return documentWidth;

}
public static float Height() {
	float documentHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
	return documentHeight;
}
public static void  report(String comments, String Screenshot) throws Exception {
	addParagraph(comments);
	addScreenshot(Screenshot);
}


private static class HeaderFooterPageEvent extends PdfPageEventHelper {
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        // Create a table with one cell to hold the header
        PdfPTable headerTable = new PdfPTable(1);
        headerTable.setTotalWidth(500F);
        headerTable.getDefaultCell().setBackgroundColor(BaseColor.BLUE);
       

        // Create a cell and add the header text
        //Paragraph headerText = new Paragraph("Collibra");
        BaseColor textColor = new BaseColor(169,169,169);
        Phrase headerText=new Phrase("Collibra",new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD,textColor));
       
        PdfPCell headerCell = new PdfPCell(headerText);
        headerCell.setBorder(PdfPTable.ALIGN_CENTER);
        headerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        headerCell.setBackgroundColor(new BaseColor(0,128,128)); // LightBlue color
        // Add the cell to the table
        headerTable.addCell(headerCell);

        // Get the PdfContentByte to write in the header
        PdfContentByte cb = writer.getDirectContent();

        // Add the table to the document's header at a specific position
        headerTable.writeSelectedRows(0, -1, 36, document.top() + 20, cb);
        
        
        

        // Add the cell to the table
       // headerTable.addCell(headerCell);
        
        //Footer
        PdfPTable footerTable = new PdfPTable(1);
        footerTable.setTotalWidth(500F);
       
       

        // Create a cell and add the footer text
        BaseColor footertextColor = new BaseColor(169,169,169);
        Phrase footerText=new Phrase("Tyson Foods...",new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD,footertextColor));
       // Paragraph footerText = new Paragraph("Tyson Foods...");
        PdfPCell footerCell = new PdfPCell(footerText);
        footerCell.setBorder(PdfPTable.ALIGN_CENTER);
        footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        footerCell.setBackgroundColor(new BaseColor(0,128,128)); 
        
        footerTable.addCell(footerCell);

        // Get the PdfContentByte to write in the header
        PdfContentByte cb1 = writer.getDirectContent();
        footerTable.writeSelectedRows(0, -1, 36, document.bottom() + 20, cb1);
    }
}

static class OuterBorderEvent extends PdfPageEventHelper {
    public void onEndPage(PdfWriter writer, Document document) {
        // Add an outer border to each page
        PdfContentByte canvas = writer.getDirectContentUnder();

        // Get the size of the page
        float pageSizeWidth = document.getPageSize().getWidth();
        float pageSizeHeight = document.getPageSize().getHeight();

        // Set the border width
        float borderWidth = 5; // Adjust the width as needed

        // Set the border color
        canvas.setColorStroke(BaseColor.BLACK); // Adjust the color as needed

        // Draw the top border
        canvas.moveTo(0, pageSizeHeight);
        canvas.lineTo(pageSizeWidth, pageSizeHeight);
        canvas.setLineWidth(borderWidth);
        canvas.stroke();

        // Draw the bottom border
        canvas.moveTo(0, 0);
        canvas.lineTo(pageSizeWidth, 0);
        canvas.setLineWidth(borderWidth);
        canvas.stroke();

        // Draw the left border
        canvas.moveTo(0, 0);
        canvas.lineTo(0, pageSizeHeight);
        canvas.setLineWidth(borderWidth);
        canvas.stroke();

        // Draw the right border
        canvas.moveTo(pageSizeWidth, 0);
        canvas.lineTo(pageSizeWidth, pageSizeHeight);
        canvas.setLineWidth(borderWidth);
        canvas.stroke();
    }
}
static class HeaderFooter extends PdfPageEventHelper {

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            // Step 1: Get the PdfContentByte for the header
            PdfContentByte cb = writer.getDirectContent();
            
            // Step 2: Add your header logo image
            Image logo = Image.getInstance("./Logo/TysonLogo.png");
            logo.scaleToFit(100, 100); // adjust the size as needed
            float xPosition = document.right() - logo.getScaledWidth() - 0; // adjust the margin as needed
            float yPosition = document.top() - logo.getScaledHeight() - 0;

            // Set the absolute position of the logo
            logo.setAbsolutePosition(xPosition, yPosition);
            cb.addImage(logo);
            
            
			/*
			 * // Position the logo on the page logo.setAbsolutePosition(20, document.top()
			 * - logo.getScaledHeight() - 10);
			 * 
			 * // Step 3: Add the image to the header
			 * 
			 * cb.addImage(logo);
			 */
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}

}