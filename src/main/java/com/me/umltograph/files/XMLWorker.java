package com.me.umltograph.files;

import java.io.File;

import com.tinkerpop.blueprints.Graph;
public interface XMLWorker {
	public void readGraph(File xml);
	public Graph getGraph();
	public void setMasters(File master);
}
