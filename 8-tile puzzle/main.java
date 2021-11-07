import java.util.*;
class main{
    public static void main(String [] args){
        int [][] board= {{1,2,3},{0,4,6},{7,5,8}};
        System.out.println("Below is the Path to Goal State : \n");
        slidepuzzle(board,1,0);
    }
    static int [] rdir={-1,0,1,0};
    static int [] cdir={0,1,0,-1};
    static int[][] goal={{1,2,3},{4,5,6},{7,8,0}};
 
    public static void addval(int [] [] cb,int [][]rb){
        for(int i=0;i<cb.length;i++){
            for(int j=0;j<cb[0].length;j++){
                cb[i][j]=rb[i][j];
            }
        }
    }
    public static void display(int [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------\n");
    }
    public static int gethuristic(int [][] board){
        int h=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!=goal[i][j] && goal[i][j]!=0){
                    h++;
                }
            }
        }
        return h;
    }
    static class Spuzzle implements Comparable<Spuzzle>{
        int [][]board;
        int r,c,h,f,g;
        public Spuzzle(int [][] board,int g,int h,int f,int r,int c){
            this.board=board;
            this.g=g;
            this.h=h;
            this.f=f;
            this.r=r;
            this.c=c;
        }
        public int compareTo(Spuzzle o){
            return this.f-o.f;
        }
    }
   public static void slidepuzzle(int [] [] board,int cr,int cc){
    PriorityQueue<Spuzzle> pq=new PriorityQueue<>();
    int n=board.length;
    int hur=gethuristic(board);
    pq.add(new Spuzzle(board,0,hur,0+hur,cr,cc));
 
    while(pq.size()<16){
        Spuzzle rem=pq.remove();
        int [][] pboard=rem.board;
        int er=rem.r;
        int ec=rem.c;
        int h=rem.h;
        int g=rem.g;
        int f=rem.f;
        if(h==0){
            System.out.println("--------------Solution/Goal Acheived--------------");
            System.out.println("Goal : "+g+" Huristic : "+h+" Function cost : "+f);
            display(pboard);
            System.exit(0);
        }
        System.out.println("Goal : "+g+" Huristic : "+h+" Function cost : "+f);
        display(pboard);
        for(int i=0;i<4;i++){
            int r=er + rdir[i];
            int c=ec + cdir[i];
            if(r>=0 && c>=0 && r<n && c<n){
                int [][] newboard = new int [n][n];
                addval(newboard,pboard);
                newboard[er][ec]=pboard[r][c];
                newboard[r][c]=0;
                int H=gethuristic(newboard);
                int G=g+1;
                int F=H+G;
                pq.add(new Spuzzle(newboard,G,H,F,r,c));
 
            }
        }
    }   
    }
}
