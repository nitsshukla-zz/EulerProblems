package com.maths.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_AM {
	List<List<Integer>> edges = new ArrayList<List<Integer>>();

	public Graph_AM(int i) {
		while(i>0){
			edges.add(new ArrayList<Integer>());
			i--;
		}
	}

	public void updateEdge(int i, int j) {
		if(i>=edges.size() || j>=edges.size()|| i<0 || j<0 || edges.get(i-1).contains(j-1) )return;
		edges.get(i-1).add(j-1);
		if(i!=j)edges.get(j-1).add(i-1);
	}

	public boolean isConnected() {
		boolean[] ar = new boolean[edges.size()];
		Arrays.fill(ar, false);
		for(int i=0;i<edges.size();i++){
			List<Integer> l=edges.get(i);
			for(Integer li:l){
				ar[li]=true;ar[i]=true;
			}
		}
		for(boolean con:ar)
			if(!con)return false;
		return true;
	}
	public Node[] getBfs(int root1) {
		Node[] ns = new Node[edges.size()];
		for(int i=0;i<edges.size();i++)ns[i]=new Node(i);
		Node root = ns[root1-1];root.distance=0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node cur=q.remove();
			for(Integer i:edges.get(cur.index)){
				if(ns[i].distance==Integer.MAX_VALUE){
					ns[i].distance=cur.distance+1;
					q.add(ns[i]);
				}
			}
		}
		return ns;
	}
}
