package com.maths.graph;


import com.maths.util.Matrix;

public class ConnectedNess {
	public static void main(String[] args) {
		/*Graph g = new Graph(5);*/
		Graph_AM g = new Graph_AM(4);
		update(g);
		System.out.println(g.isConnected());
		/*System.out.println(g.isConnected(1));
		System.out.println(g.numberOfConnectedComponent());
		System.out.println(g.isBridge(1,2));
		*//*int[][] m1=g.matrix;
		int[][] m2 = Matrix.multiply(g.matrix, g.matrix);
		int[][] m3 = Matrix.multiply(m1,m2);
		int[][] m4 = Matrix.multiply(m2,m2);
		int[][] m5 = Matrix.multiply(m2,m3);
		int[][] ans = Matrix.add(m1, m2);
		
		ans = Matrix.add(ans, m3);

		ans = Matrix.add(ans, m4);
		
		ans = Matrix.add(ans, m5);
		Matrix.showMatrix(ans);
		//ans=Matrix.multiply(ans, ans);
		
		//Matrix.showMatrix(m4);
		System.out.println();
		Matrix.showMatrix(Matrix.powSum(m1, 5));*/
	}

	private static void update(/*Graph*/Graph_AM g) {
		g.updateEdge(1, 2);
		g.updateEdge(2, 3);
		g.updateEdge(3, 3);
		g.updateEdge(1, 3);
	}
}
