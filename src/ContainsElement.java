//Given a sorted array and a number key, return whether the key is present in the array or not.

public class ContainsElement {
    boolean containsElement (int[] arr, int key) {
        // add your logic here
        int start = 0;
        int end = arr.length-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==key)
            {
                return true;
            }
            else if(arr[mid] > key)
            {
                end = mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return false;
    }

    public static  void main(String args[]) {
        int[] array = {1, 2, 3, 3, 3, 4, 4, 5};
        int target = 2;
        ContainsElement rs = new ContainsElement();
        rs.containsElement(array,target);
    }
}
