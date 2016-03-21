package com.maths.graph;

import java.util.Arrays;

public class Node {
	int index,weight,distance;
	public Node(int i){index=i;weight=1;distance=Integer.MAX_VALUE;}
	@Override
	public String toString() {
		return "Node [index=" + index + ", distance=" + distance + "]\n";
	}
	public static void main(String[] args) {
		Graph_AM g = new Graph_AM(10);
		for(int i=1;i<=10;i++)
			g.updateEdge(i, i+1);
		System.out.println(Arrays.toString(g.getBfs(9)));
	}
}
