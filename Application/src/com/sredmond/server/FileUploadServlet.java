package com.sredmond.server;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import org.apache.commons.fileupload.FileItemIterator; 
import org.apache.commons.fileupload.FileItemStream; 
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.ibm.icu.text.MessagePattern.Part; 


@SuppressWarnings("serial")
public class FileUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ServletFileUpload fu = new ServletFileUpload();
		
		try
		{
			FileItemIterator itr = fu.getItemIterator(req);
			
			while(itr.hasNext()) {
				FileItemStream item = itr.next();
				InputStream is = new BufferedInputStream(item.openStream());
				File png = File.createTempFile("PNG", ".png");
				File tiff = File.createTempFile("TIFF", ".tiff");
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(png));
				int data = -1;
				
				while((data = is.read()) != -1) {
					out.write(data);
				}
				
				
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}

	}
}