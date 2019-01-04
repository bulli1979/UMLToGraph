package com.me.thesisuml;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.me.umltograph.files.FileType;
import com.me.umltograph.files.FileWorker;
import com.me.umltograph.files.Tools;
import com.me.umltograph.files.XMLWorker;



public class TestFileHandling {
	public final static String DESTINATION = System.getProperty("user.home") + File.separator + "temp";
	@Test
	public void testFileHanlder() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File auswahlprozess = new File(classLoader.getResource("p1_auswahlprozess.vsdx").getFile());
		if (auswahlprozess != null) {
			FileWorker fw = new FileWorker(auswahlprozess,DESTINATION);
			fw.execute();
		}
		File login = new File(classLoader.getResource("p1_login.vsdx").getFile());
		if (login != null) {
			FileWorker fw = new FileWorker(login,DESTINATION);
			fw.execute();
		}
		File manualEdit = new File(classLoader.getResource("p1_manualEdit.vsdx").getFile());
		if (manualEdit != null) {
			FileWorker fw = new FileWorker(manualEdit,DESTINATION);
			fw.execute();
		}
		File p2_login = new File(classLoader.getResource("p2_login.vsdx").getFile());
		if (p2_login != null) {
			FileWorker fw = new FileWorker(p2_login,DESTINATION);
			fw.execute();
			
		}
		File p2_spesenBeantragen = new File(classLoader.getResource("p2_spesenBeantragen.vsdx").getFile());
		if (p2_spesenBeantragen != null) {
			FileWorker fw = new FileWorker(p2_spesenBeantragen,DESTINATION);
			fw.execute();
		}
		File p2_spesenFreigeben = new File(classLoader.getResource("p2_spesenFreigeben.vsdx").getFile());
		if (p2_spesenFreigeben != null) {
			FileWorker fw = new FileWorker(p2_spesenFreigeben,DESTINATION);
			fw.execute();
		}
		File p2_urlaub = new File(classLoader.getResource("p2_urlaubBeantragen.vsdx").getFile());
		if (p2_urlaub != null) {
			FileWorker fw = new FileWorker(p2_urlaub,DESTINATION);
			fw.execute();
		}
		File p2_urlaubBearbeiten = new File(classLoader.getResource("p2_urlaubFreigeben.vsdx").getFile());
		if (p2_urlaubBearbeiten != null) {
			FileWorker fw = new FileWorker(p2_urlaubBearbeiten,DESTINATION);
			fw.execute();
		}
		
		File p3_artikelInDenWarenkorb = new File(classLoader.getResource("p3_artikelInDenWarenkorb.vsdx").getFile());
		if (p3_artikelInDenWarenkorb != null) {
			FileWorker fw = new FileWorker(p3_artikelInDenWarenkorb,DESTINATION);
			fw.execute();
		}
		File p3_registrieren = new File(classLoader.getResource("p3_registrieren.vsdx").getFile());
		if (p3_registrieren != null) {
			FileWorker fw = new FileWorker(p3_registrieren,DESTINATION);
			fw.execute();
		}
		File p3_zahlvorgang = new File(classLoader.getResource("p3_zahlvorgang.vsdx").getFile());
		if (p3_zahlvorgang != null) {
			FileWorker fw = new FileWorker(p3_zahlvorgang,DESTINATION);
			fw.execute();
		}
		
	}
	@Test
	public void TestTypeFinding(){
		String fileName = "auswahlprozess.vsdx";
		String ending = Tools.INSTANCE.getEnding(fileName);
		assertTrue(ending.equals("vsdx"));
		XMLWorker worker = FileType.findWorker(ending);
		assertTrue(worker.getClass().getName().equals("com.me.umltograph.files.XMLVisioWorker"));
		
	}
}
