package com.leetcode.of;

public	class	J11{

	public int minArray(int[] numbers){
		int left=0,right=numbers.length-1;
			while(left<right){
				int mid=(right+left) /2;
				if(numbers[mid]>numbers[right]){
					left=mid+1;
				} else if(numbers[mid]<numbers[right]){
					right=mid;
				}else{
					right--;
				}
			}
		return numbers[left];
	}

	public static void main (String[] args) {
		
	}

}
