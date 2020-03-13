package eg.edu.alexu.csd.filestructure.sort;


import java.util.ArrayList;

public class Sort <T extends Comparable<T>> implements ISort {
	@Override
	public IHeap heapSort(ArrayList unordered) {
		return null;
	}

	@Override
	public void sortSlow(ArrayList unordered) {
		//bubble sort
		if(unordered.size()==0||unordered.equals(null))
			return;
		for (int i=0;i<unordered.size();i++){
			for(int j=0;j<unordered.size()-1-i;j++){
				Comparable cur = (Comparable) unordered.get(j);
				Comparable next = (Comparable) unordered.get(j+1);
				if(cur.compareTo(next)>0){
					unordered.set(j,next);
					unordered.set(j+1,cur);

				}
			}
		}

	}

	@Override
	public void sortFast(ArrayList unordered) {
		if (unordered == null || unordered.size() == 0) return;
		int l = 0;
		int r = unordered.size() - 1;
		mergeSort(unordered, l, r);
	}

	public void mergeSort(ArrayList unordered ,int l,int r){
		if (l<r){
			int m=(r+l)/2;
			mergeSort(unordered,l,m);
			mergeSort(unordered,m+1,r);
			merge(unordered,l,m,r);

		}
	}
	public void merge(ArrayList unordered,int l,int m,int r){
		int i=l;
		int j=m+1;
		System.out.println("hi"+unordered);
		ArrayList temp =new ArrayList();
		while (i<m+1 && j<= r){
			Comparable eleL = (Comparable) unordered.get(i);
			Comparable eleR = (Comparable) unordered.get(j);

			if (eleL.compareTo(eleR)<=0){
				temp.add(eleL);
				i++;
			}else{
				temp.add(eleR);
				j++;

			}
		}
		while(i<m+1){
			Comparable eleL = (Comparable) unordered.get(i);
			temp.add(eleL);
			i++;
		}
		while(j<= r){
			Comparable eleR = (Comparable) unordered.get(j);
			temp.add(eleR);
			j++;
		}
		for(i = 0; i < temp.size(); i++) {
			unordered.set(l + i, temp.get(i));
		}
		System.out.println("finally"+unordered);


	}

//	public static void main(String args[])
//	{
//		ArrayList<Integer> n =new ArrayList<Integer>();
//		n.add(12);
//		n.add(11);
//		n.add(13);
//		n.add(5);
//		n.add(6);
//		n.add(7);
//
//
//		System.out.println(n);
//
//		Sort ob = new Sort();
//		ob.mergeSort(n,0,n.size()-1);
//
//		System.out.println("\nSorted array");
//		System.out.println(ob.toString());
//	}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
