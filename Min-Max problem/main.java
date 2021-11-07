import java.util.*;
public class main{
 
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();
        int [] scores=new int[n];
        System.out.println("Enter "+n+" scores");
        for(int i=0;i<n;i++){
            scores[i]=sc.nextInt();
        }
        int h=log2(n);
        int result=minmax(0,0,scores,h,true);
        System.out.println("The solution is "+result);
    
    }
    public static int log2(int n){
        return n==1? 0 : 1 + log2(n/2);
    }
    public static int minmax(int depth,int currnode,int [] scores,int height,boolean maxmin){
 
        if(depth==height){
            return scores[currnode];
        }
 
        if(maxmin==true){
            return Math.max(minmax(depth+1, currnode*2, scores, height, false), minmax(depth+1, currnode*2 + 1, scores, height, false));
        }
        else{
            return Math.min(minmax(depth+1, currnode*2, scores, height, true), minmax(depth+1, currnode*2 + 1, scores, height, true));
        }
    }
}
