import java.util.*;
public class main
{
    static class Jpair{
        int j1;
        int j2;
        public Jpair(int j1,int j2){
            this.j1=j1;
            this.j2=j2;
        }
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter J1 capacity");
    int m=sc.nextInt();
    System.out.println("Enter J2 capacity");
    int n=sc.nextInt();
    System.out.println("Enter d litres of water");
    int d=sc.nextInt();
    System.out.println("Way to get "+d+" litres of water in a Jug :");
    pourwater(m,n,d);
    }
    
    public static void pourwater(int m,int n,int d){
       Queue<Jpair> q=new LinkedList<>();
       q.add(new Jpair(0,0));
       
       while(q.size()>0 ){
           Jpair rem=q.remove();
           int j1=rem.j1;
           int j2=rem.j2;
           
           System.out.println("J1= "+j1+" J2= "+j2);
           if(j1==d || j2==d){
               if(j1==d){
                   j2=0;
               }
               else{
                   j1=0;
               }
               System.out.println("J1= "+j1+" J2= "+j2);
               System.exit(0);
           }
          
           if(j1==0 && j2==0){
               q.add(new Jpair(m,0));
           }
           if(j1!=0 && j2==0){
               q.add(new Jpair(0,j1));
           }
           if(j1==0 && j2!=0){
               q.add(new Jpair(m,j2));
           }
           if(j1!=0 && j2!=0){
               if(j2<n){
                   int tv=n-j2;
                   j2+=tv;
                   j1-=tv;
               }
               else{
                   j2=0;
               }
               q.add(new Jpair(j1,j2));
           }   
       }       
    }
}
