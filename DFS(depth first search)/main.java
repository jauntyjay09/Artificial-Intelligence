import java.util.*;
class main{
static class Edge{
    int src;
    int nbr;
    public Edge(int s,int d){
        src=s;
        nbr=d;
    }
}
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int v=sc.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        System.out.println("Enter number of edges");
        int e=sc.nextInt();
        System.out.println("Enter Each edge ");
        for(int i=0;i<e;i++){
            System.out.print("Edge "+(i+1)+" : ");
            int s=sc.nextInt()-1;
            int d=sc.nextInt()-1;
            graph[s].add(new Edge(s,d));
            graph[d].add(new Edge(d,s));
        }
        boolean []vis=new boolean[v];
        System.out.println("Enter source and goal vertex");
        int src=sc.nextInt()-1;
        int goal=sc.nextInt()-1;
        asf=""+(src+1);
        DFS(src,goal,graph,vis);
    }
    static String asf;
    public static void DFS(int src,int goal,ArrayList<Edge> [] graph,boolean [] vis){
        if(src==goal){
            System.out.println("DFS Path to reach goal : "+asf);
            return;
        }
        vis[src]=true;
        for(Edge e:graph[src]){
            int nbr=e.nbr;
            if(vis[nbr]==false){
                asf+="->"+(nbr+1);
                DFS(nbr,goal,graph,vis);
            }
        }
    }
}
