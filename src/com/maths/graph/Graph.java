package com.maths.graph;

import java.util.Arrays;

import com.maths.util.Matrix;

public class Graph {
	float[][] matrix= null;
	public Graph(int v){
		matrix = new float[v][v];
	}
	public void updateEdge(int v1, int v2){
		matrix[v1][v2]=1;matrix[v2][v1]=1;
	}
	public boolean isConnected(){
		float[][] a =Matrix.powSum(matrix, matrix.length);
		Matrix.showMatrix(a);
		for(int i=0;i<matrix.length;i++)
			for(int i1=0;i1<matrix.length;i1++)
				if(a[i][i1]==0)return false;
		return true;
	}
	public boolean isConnected(int regularDegree){
		float[][] a =Matrix.powSum(matrix, regularDegree+1);
		Matrix.showMatrix(a);
		for(int i=0;i<matrix.length;i++)
			for(int i1=0;i1<matrix.length;i1++)
				if(a[i][i1]==0)return false;
		return true;
	}
	public int numberOfConnectedComponent(){
		boolean[] a = new boolean[matrix.length];Arrays.fill(a, false);
		int aa=0,cc=0;
		while(aa!=matrix.length){
			int un =getUnAttended(a);
			if(un==-1)break;
		    aa+=markAll(un,a);
		    cc++;
		}
		return cc;
	}
	public boolean isBridge(int i, int i1){
		if(i>=matrix.length || i1>=matrix.length)throw new IllegalArgumentException("Argument exceeded size");
		Graph g_c = new Graph(matrix.length);
		g_c.matrix = Matrix.deepCopyIntMatrix(this.matrix);
		g_c.removeEdge(i,i1);
		return this.numberOfConnectedComponent()<g_c.numberOfConnectedComponent();
	}
	
	public void removeEdge(int i, int i1) {
		this.matrix[i][i1]=0;
		this.matrix[i1][i]=0;
	}
	public void deleteVertex(int i) {
		float[] a = this.matrix[i];
		for(int i1=0;i1<a.length;i1++)
			a[i1]=0;
	}
	private int markAll(int un, boolean[] a) {
		int ans=0;a[un]=true;
		for(int i=0;i<matrix.length;i++){
			if(matrix[un][i]==1 && un!=i && !a[i])
				ans+=markAll(i,a);
		}
		return ans+1;
	}
	private int getUnAttended(boolean[] a) {
		for(int i=0;i<a.length;i++)
			if(!a[i])return i;
		return -1;
	}
	
}
