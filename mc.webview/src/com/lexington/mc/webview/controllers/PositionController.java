package com.lexington.mc.webview.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lexington.mc.logic.providers.ExportViewProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.beans.ManageUser;
import com.lexington.mc.webview.util.FacesUtil;

@ManagedBean(name="position")
public class PositionController {

	private Timestamp fechDate4;
	private Timestamp fechDate5;

	public StreamedContent getExportAccountPosition() {
		
		 if(fechDate4 == null || fechDate5 == null){
				FacesUtil.throwWarning("dateFieldsAreRequired");
				return null;
				
			}
		
		
		
		ManageUser user = (ManageUser) FacesUtil.getSessionMapValue("user");
		ExportViewProvider provider = new ExportViewProvider();

		StreamedContent file = null;
		InputStream stream = null;
		byte[] excelBlob;
		try {
			excelBlob = provider.generateExcelFileForAccountPositions(user.getCurUser().getEntityBank().getBank().getBANK_ID().toString(),
					fechDate4, fechDate5);
			stream = new ByteArrayInputStream(excelBlob);
			file = new DefaultStreamedContent(stream,
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "Position info" + ".xlsx");
		} catch (MessageException e) {
			// TODO Auto-generated catch block
			FacesUtil.throwMessage(e);
		}
		return file;
	}

	public Timestamp getFechDate4() {
		return fechDate4;
	}

	public void setFechDate4(Timestamp fechDate4) {
		this.fechDate4 = fechDate4;
	}

	public Timestamp getFechDate5() {
		return fechDate5;
	}

	public void setFechDate5(Timestamp fechDate5) {
		this.fechDate5 = fechDate5;
	}
	
	

	

	
}
