import java.util.Arrays; 

public class binarySearch{
	public static void main(String args[]){
		int[] arr = new int[]{1,7,6,5,4,2,8,12,9,12};
		binarySearch sr = new binarySearch();
		sr.sort(arr);
		
		int[] arrSorted = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(sr.find(arrSorted,5));
		System.out.println(Arrays.toString(arr));
	}

	public int find(int[] arr, int x){
		int b = 0 , e = arr.length-1;
		int middle ;
		while(b<e){
			middle = b + (e-b)/2;
			if (arr[middle] == x) return middle;
			if (arr[middle] > x) 
				e = middle-1;
			else 
				b = middle+1;
		}
		return -1;
	}
	
	public void sort(int[] arr){
		recSort(arr, 0, arr.length-1);
	}

	private void recSort(int[] arr, int start, int end){
		int l=start,r= end;
		int pivot = arr[ start + ( end - start ) / 2];
		while (l<r){
			while(arr[l]<pivot)
				l++;
			while (arr[r]>pivot)
				r--;
			if (l<=r){
				int tmp = arr[r];
				arr[r]=arr[l];
				arr[l]=tmp;
				l++;
				r--;
			}
			if (start < r){
				recSort(arr,start,r);
			}
			if (end > l){
				recSort(arr,l,end);
			}
		}
	}	
}
