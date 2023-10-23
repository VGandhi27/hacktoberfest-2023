public class FirstLastOcc {

	public static void main(String[] args) {
		int arr[]= {2,4,10,10,10,18,20};
		int x=10;
		System.out.println("the first index of element is "+first(arr,x));
		System.out.println("the first index of element is "+last(arr,x));

	}
	
	public static int first(int arr[], int x) {
		int start=0, end=arr.length-1;
		
		int result=-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==x) {
				result=mid;
				end=mid-1;
			}
			else if(arr[mid]<x) {
				start=mid+1;
			}
			else end=mid-1;
			
		}
		return result;
	}
  
	public static int last(int arr[], int x) {
		int start=0, end=arr.length-1;
		
		int result=-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==x) {
				result=mid;
				start=mid+1;
			}
			else if(arr[mid]<x) {
				start=mid+1;
			}
			else end=mid-1;
		}
		return result;
  }
}
