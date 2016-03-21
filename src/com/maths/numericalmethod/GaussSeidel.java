package com.maths.numericalmethod;

import java.util.Arrays;

import com.maths.util.Matrix;

public class GaussSeidel {
	public static void main(String[] args) {
		float[][] a = new float[][] { new float[] { 10, -1,2,0 }, new float[] { -1,11,-1,3	 } },
				b = new float[][] { new float[] { 11 }, new float[] { 13 } };
		float[][] l = getLower(a), u = getUpper(a);
		float[][] lI = Matrix.invert(l), lIb = Matrix.multiply(lI, b), lIU = Matrix.multiply(lI, u);
		float[][] mlIu = Matrix.multiplyAll(lIU, -1);
		float[][] x = new float[][] { new float[] { 1.1f }, new float[] { 2.3f } };
		for(int i=0;i<10;i++){
			x=applyGaussSiedel(x, lIb, mlIu);
			Matrix.showMatrix(x);
		}
	}

	private static float[][] applyGaussSiedel(float[][] x, float[][] lIb, float[][] mlIu) {
		float[][] ans = Matrix.multiply(mlIu, x);
		return Matrix.add(ans, lIb);
	}

	private static float[][] getLower(float[][] m) {
		float[][] mat = new float[m.length][m.length];
		for (int i1 = 0; i1 < mat.length; i1++) {
			Arrays.fill(mat[i1], 0);
			for (int i = 0; i <= i1; i++)
				mat[i1][i] = m[i1][i];
		}
		return mat;
	}

	private static float[][] getUpper(float[][] m) {
		float[][] mat = new float[m.length][m.length];
		for (int i1 = 0; i1 < mat.length; i1++) {
			Arrays.fill(mat[i1], 0);
			for (int i = i1 + 1; i < m.length; i++)
				mat[i1][i] = m[i1][i];
		}
		return mat;
	}
}
