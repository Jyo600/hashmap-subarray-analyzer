import java.io.*;
import java.util.*;
public class subbArraySumAnalyser{
    public static int countSubarrays(int[]nums,int k){
        int sum=0;
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
                map.put(sum,map.getOrDefault(sum,0)+1);
            
            

        }
        return count;

    }
    //finding the longestsubarray
    public static int longestSubarray(int[]nums,int k){
        int sum=0;
        int maxLen=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        
        if(sum==k){
            maxLen=i+1;
        }
        if(map.containsKey(sum-k)){
            int len=i-map.get(sum-k);
            maxLen=Math.max(maxLen,len);
        }
        if(!map.containsKey(sum)){
            map.put(sum,i);
        }

    }
    return maxLen;


    }
    public static void main(String args[]){
        int[]nums={1,2,1,0,1,1,0};
        int k=4;
        int count=countSubarrays(nums,k);
        int longest=longestSubarray(nums,k);
        System.out.println("the count of the suarray is the :"+count);
        System.out.println("the longest subarry in the :"+longest);

    }
}