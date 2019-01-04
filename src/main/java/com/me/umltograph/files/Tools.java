package com.me.umltograph.files;

public enum Tools {
	INSTANCE;
	
	public String getEnding(String fileName) {
		String[] split = fileName.split("\\.");
		return split[split.length-1];
	}

	public String getFileName(String fileName) {
		String[] split = fileName.split("\\.");
		String result = "";
		for(int i=0;i<split.length-1;i++) {
			result += split[i];
		}
		return result;
		
	}
	
}
