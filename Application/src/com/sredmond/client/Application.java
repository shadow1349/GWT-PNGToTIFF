package com.sredmond.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Application implements EntryPoint {

	private final String allowedext = ".png";
	public void onModuleLoad() {
		VerticalPanel vp = new VerticalPanel();
		final FileUpload fileUpload = new FileUpload();
		Button upload = new Button("Upload");
		upload.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String file = fileUpload.getFilename();
				if(file.length() != 0) {
					String fileExtention = file.substring(file.length() - allowedext.length(), file.length());
					if(!fileExtention.equals(allowedext)) {
						Window.alert("Only PNGs are allowed");
					}
					else {
						Window.alert("File uploaded successfully");
					}
				}
				else {
					Window.alert("Please choose a file");
				}
				
			}
		});
		
		vp.add(fileUpload);
		vp.add(upload);
		RootPanel.get().add(vp);


	}
}