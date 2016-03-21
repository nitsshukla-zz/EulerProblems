package com.os.page;

import java.util.LinkedList;
import java.util.Queue;

public class PageReplacement {
	public static void main(String[] args) {
		int[] pages = new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		System.out.println(pageFaultsFIFO(pages,3));
		System.out.println(pageFaultsStack(pages,3));
	}

	private static int pageFaultsFIFO(int[] pages, int fifoSize) {
		Queue<Integer> fifo = new LinkedList<Integer>();
		int res=0;
		for(int i:pages){
			if(!fifo.contains(i)){
				if(fifo.size()<fifoSize){
					fifo.add(i);
				}
				else{
					fifo.poll();
					fifo.add(i);
				}
				res++;
			}
		}
		return res;
	}
	private static int pageFaultsStack(int[] pages, int stackSize) {
		LinkedList<Integer> fifo = new LinkedList<Integer>();
		int res=0;
		for(int i:pages){
			if(!fifo.contains(i)){
				if(fifo.size()<stackSize){
					fifo.addFirst(i);
				}
				else{
					fifo.removeLast();
					fifo.addFirst(i);
				}
				res++;
			}
			else{
				fifo.removeFirstOccurrence(i);
				fifo.addFirst(i);
			}
		System.out.println(fifo);
		}
		return res;
	}
}
