package com.me.umltograph.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.me.umtograph.graph.GMLOutput;
import com.tinkerpop.blueprints.Graph;


public class FileWorker {
	private File file;
	private String desitnation;
	private String outputName;
	private static final String GRAPH_ENDING = ".gml";

	public FileWorker(File file,String destination) {
		this.file = file;
		this.desitnation = destination;
		outputName = Tools.INSTANCE.getFileName(this.file.getName());
	}

	public String execute() throws IOException {
		String answer = "OK";
		File zip = new File("temp.zip");
		file.renameTo(zip);
		if (zip.exists()) {
			unzip();
		}

		return answer;
	}

	private void unzip() {
		File dir = new File(desitnation);
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis;
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(file);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			File pages = null;
			File master = null;
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(desitnation + File.separator + fileName);
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				zis.closeEntry();
				ze = zis.getNextEntry();
				if(newFile.getName().equals("page1.xml")) {
					pages = new File(newFile.getAbsolutePath());
				}
				if(newFile.getName().equals("masters.xml")) {
					master = new File(newFile.getAbsolutePath());
				}
				
				
				
				
			}
			XMLWorker worker = FileType.findWorker(Tools.INSTANCE.getEnding(file.getName()));
			if(master.exists()) {
				System.out.println("Master Exists");
				worker.setMasters(master);
			}
			
			if(pages.exists()) {
				
				worker.readGraph(pages);
				Graph graph = worker.getGraph();
				GMLOutput gmlop = new GMLOutput();
				gmlop.writeGML(graph, desitnation + File.separator + outputName + GRAPH_ENDING);
			}
			
			// close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
