import java.util.*;

public class RotatedArray {
/*
Brute force approach -> O(n)
for(int i =0;i<array.length-1;i++)
{
   if(array[i]==target)
   {
         return i
   }
   return -1;
}
 */

    //Modified Binary Search -> O(log N)
    public  int solve(int[] array,int target)
    {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                //System.out.println(mid);
                return mid;
            }
            if (array[start] <= array[mid]) //means left side of mid is sorted
            {
                if (target >= array[start] && target < array[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else {    //right part of array would be sorted
                if (target > array[mid] && target <= array[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return  -1;
    }


    public static  void main(String args[]) {
        int[] array = {4, 5, 6, 7, 1, 2, 3};
        int target = 6;
        RotatedArray rs = new RotatedArray();
       rs.solve(array,target);
    }
}