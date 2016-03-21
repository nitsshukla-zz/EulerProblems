package com.maths.util;

import java.util.Arrays;

public class Matrix {
	/*
	 * public static void main(String[] args) {
	 * 
	 * int[][] m1 = new int[][]{ new int[]{1,2}, new int[]{1,2} }; int[][] m2 =
	 * new int[][]{ new int[]{1,2}, new int[]{1,2} }; int[][] ans =
	 * Matrix.multiply(m1, m2); for(int[] ar: ans)
	 * System.out.println(Arrays.toString(ar));
	 * 
	 * }
	 */
	public static float[][] multiply(float[][] lI, float[][] b) {
		int m1rows = lI.length;
		int m1cols = lI[0].length;
		int m2rows = b.length;
		int m2cols = b[0].length;
		if (m1cols != m2rows)
			throw new IllegalArgumentException("matrices don't match: " + m1cols + " != " + m2rows);
		float[][] result = new float[m1rows][m2cols];
		for (int i = 0; i < m1rows; i++) {
			for (int j = 0; j < m2cols; j++) {
				for (int k = 0; k < m1cols; k++) {
					result[i][j] += lI[i][k] * b[k][j];
				}
			}
		}
		return result;
	}

	public static float[][] inverse(float[][] l) {
		float[][] matrix = deepCopyIntMatrix(l);
		if (matrix.length == 2) {
			if (matrix[0].length == 2 && matrix[1].length == 2) {
				float det = determinant(matrix);
				float temp = matrix[0][0];
				matrix[0][0] = matrix[1][1];
				matrix[1][1] = temp;
				matrix[0][1] *= -1;
				matrix[1][0] *= -1;
				matrix = multiplyAll(matrix, (float) 1 / det);
				return matrix;
			}
		}
		return null;
	}

	public static float[][] multiplyAll(float[][] matrix, float m) {
		for (int i1 = 0; i1 < matrix.length; i1++)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][i1] *= m;
		return matrix;
	}

	/*private static float determinant(float[][] matrix) {
		if (matrix.length == 2)
			if (matrix[0].length == 2 && matrix[1].length == 2)
				return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		return Float.MIN_VALUE;
	}*/

	public static float[][] add(float[][] m, float[][] res) {
		int m1rows = m.length;
		int m1cols = m[0].length;
		int m2rows = res.length;
		int m2cols = res[0].length;
		if (m1cols != m2cols || m1rows != m2rows)
			throw new IllegalArgumentException("matrices don't match: ");
		float[][] result = new float[m1rows][m2cols];
		for (int i = 0; i < m1rows; i++) {
			for (int j = 0; j < m2cols; j++) {
				result[i][j] += m[i][j] + res[i][j];
			}
		}
		return result;
	}

	public static void showMatrix(float[][] l) {
		for (float[] ar : l)
			System.out.println(Arrays.toString(ar));
		System.out.println("*****************************************************************");
	}

	public static float[][] pow(float[][] m, float power) {
		if (power == 1)
			return m;
		else if (power < 1)
			throw new IllegalArgumentException("Wrong power Argument");
		float[][] res = multiply(m, m);
		for (int i = 2; i < power; i++) {
			res = multiply(res, m);
		}
		return res;
	}

	public static float[][] powSum(float[][] m, int power) {
		if (power == 1)
			return m;
		else if (power < 1)
			throw new IllegalArgumentException("Wrong power Argument");
		float[][] res = multiply(m, m);
		float[][] temp = res;
		res = add(m, res);
		for (int i = 2; i < power; i++) {
			temp = multiply(temp, m);
			res = add(res, temp);
		}
		return res;
	}

	public static float[][] deepCopyIntMatrix(float[][] l) {
		if (l == null)
			return null;
		float[][] result = new float[l.length][];
		for (int r = 0; r < l.length; r++) {
			result[r] = l[r].clone();
		}
		return result;
	}

	/**
	 * Sets the destination matrix to the identity matrix.
	 * 
	 * @param dst
	 *            the destination matrix
	 */
	public static void identity(float dst[][]) {
		for (int i = 0; i < dst.length; i++)
			for (int j = 0; j < dst.length; j++)
				dst[i][j] = (i == j ? 1 : 0);
	}

	/**
	 * Inverts a matrix by Gaussian reduction (slow but very general).
	 * 
	 * @param mat
	 *            matrix to be inverted
	 */
	public static float[][] invert(float[][] mat1) {
		float[][] mat = deepCopyIntMatrix(mat1);
		int N = mat.length;
		float t;

		float[][] tmp = deepCopyIntMatrix(mat);
		identity(mat);
		for (int i = 0; i < N; i++) {
			if ((t = tmp[i][i]) == 0)
				break;
			for (int j = 0; j < N; j++) {
				tmp[i][j] = tmp[i][j] / t;
				mat[i][j] = mat[i][j] / t;
			}
			for (int k = 0; k < N; k++)
				if (k != i) {
					t = tmp[k][i];
					for (int j = 0; j < N; j++) {
						tmp[k][j] = tmp[k][j] - t * tmp[i][j];
						mat[k][j] = mat[k][j] - t * mat[i][j];
					}
				}
		}
		return mat;
	}

	public static float determinant(float[][] matrix) {
	    if (matrix.length == 1) {
		return matrix[0][0];
	    }
	    if (matrix.length==2) {
	        return (matrix[0][0] * matrix[1][1]) - ( matrix[0][1] * matrix[1][0]);
	    }
	    float sum = 0.0f;
	    for (int i=0; i<matrix.length; i++) {
	        //sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i));
	    	sum += changeSign(i)*matrix[0][i]*determinant(createSubMatrix(matrix,0,i));
	    }
	    return sum;
	}

	public static float[][] createSubMatrix(float[][] matrix, int excluding_row, int excluding_col) {
	    float[][] mat = new float[matrix.length-1][matrix.length-1];
	    int r = -1;
	    for (int i=0;i<matrix.length;i++) {
	        if (i==excluding_row)
	            continue;
	            r++;
	            int c = -1;
	        for (int j=0;j<matrix.length;j++) {
	            if (j==excluding_col)
	                continue;
	            mat[r][ ++c]= matrix[i][j];
	        }
	    }
	    return mat;
	} 
	private static double changeSign(int i) {
		if(i%2==0)return 1;
		 return -1;
	}
	
}