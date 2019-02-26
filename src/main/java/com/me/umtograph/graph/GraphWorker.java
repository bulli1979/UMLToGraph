package com.me.umtograph.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationFactory.ConfigurationBuilder;

import com.me.umltograph.files.Shape;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;


public class GraphWorker {
	private static final String ID = "key";
	private static final String TYPE = "type";
	private static final String LABEL = "label";

	public GraphWorker() {
	}

	private Map<Integer, Vertex> verts = new HashMap<Integer, Vertex>();

	public Graph run(List<Shape> shapes) {
		
		Configuration conf = new ConfigurationBuilder().getConfiguration();
		conf.setProperty("directed", 1);
		Graph graph = new TinkerGraph(conf);
		for (Shape shape : shapes) {
			if (shape.getFrom() == null) {
				
				createVertex(graph.addVertex(null), shape);
			}
		}

		for (Shape shape : shapes) {
			if (shape.getFrom() != null) {
				createEdge(graph, shape);
			}
		}
		return graph;
	}

	private void createEdge(Graph graph, Shape shape) {
		if (shape.getText() != null && shape.getFrom() != null && shape.getTo() != null) {
			if (verts.get(shape.getFrom()) != null && verts.get(shape.getTo()) != null) {
				Edge e = graph.addEdge(null, verts.get(shape.getFrom()), verts.get(shape.getTo()), cleanString(shape.getText()));
				e.setProperty(ID, shape.getId());
				e.setProperty(TYPE, shape.getType());
				
			}
		}
	}

	private String cleanString(String toClean) {
		toClean = toClean.trim();
		toClean = toClean.replaceAll("�", "ae");
		toClean = toClean.replaceAll("�", "Ae");
		toClean = toClean.replaceAll("�", "ue");
		toClean = toClean.replaceAll("�", "Ue");
		toClean = toClean.replaceAll("�", "oe");
		toClean = toClean.replaceAll("�", "Oe");
		toClean = toClean.trim();
		return toClean;
	}
	
	private void createVertex(Vertex vertex, Shape shape) {
		vertex.setProperty(ID, shape.getId());
		vertex.setProperty(TYPE, shape.getType());
		if (shape.getText() != null) {
			vertex.setProperty(LABEL, cleanString(shape.getText()));
		}
		verts.put(shape.getId(), vertex);
	}
}
