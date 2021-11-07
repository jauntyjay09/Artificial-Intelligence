import java.util.Scanner;
public class main{
 
 
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter N value ");
        int n=sc.nextInt();
        if(n<4){
            System.out.println("Solutions are not possible for N = "+n);
            System.exit(0);
        }
        System.out.println("Possible Solutions for N ="+n+" are printed below");
        char [][] board=new char[n][n];
        fillboard(board);
        solveNqueen(0,board);
    }
    public static void fillboard(char [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]='#';
            }     
        }
    }
    public static void display(char [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
    public static void solveNqueen(int r,char [][] board){
        if(r==board.length){
            display(board);
            return;
        }
        for(int c=0;c<board[0].length;c++){
 
             if(isSafe(r,c,board)){
             board[r][c]='Q';
             solveNqueen(r+1, board);
             board[r][c]='#';
            }
        }
    }
 
    public static boolean isSafe(int r,int c,char [][] board){
        
        for(int i=r,j=c;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
 
        for(int i=r;i>=0;i--){
            if(board[i][c]=='Q'){
                return false;
            }
        }
        for(int i=r,j=c;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
 
        return true;
 
    }
}
