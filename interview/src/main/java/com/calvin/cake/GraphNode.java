package com.calvin.cake;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GraphNode {

    private String label;
    private Set<GraphNode> neighbors;
    private Optional<String> color;

    public GraphNode(String label) {
        this.label = label;
        neighbors = new HashSet<GraphNode>();
        color = Optional.empty();
    }

    public String getLabel() {
        return label;
    }

    public Set<GraphNode> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public boolean hasColor() {
        return color.isPresent();
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color = Optional.ofNullable(color);
    }
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append(label).append(", degree:[").append(this.neighbors.size()).append("], color:[")
    		.append((color.isPresent() ? color.get() : "blank")).append("], neighbors:[");
    	if (!neighbors.isEmpty()){
        	for (GraphNode node : neighbors){
        		builder.append(node.label).append(',');        				
        	}
        	builder.setLength(builder.length() - 1);
    	}
    	builder.append("]");
    	return builder.toString();
    }
}