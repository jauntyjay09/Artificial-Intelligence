import java.util.*;
public class main
 
{   
    static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int s,int nb,int w){
            src=s;
            nbr=nb;
            wt=w;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter number of Vertices");
        int v=sc.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        System.out.println("Enter number of Edges");
        int e=sc.nextInt();
        System.out.println("Enter Edges with weight");
        for(int i=0;i<e;i++){
        System.out.print("Edge "+(i+1)+": ");
        int sr=sc.nextInt();
        int nbr=sc.nextInt();
        int wt=sc.nextInt();
        graph[sr].add(new Edge(sr,nbr,wt));
        graph[nbr].add(new Edge(nbr,sr,wt));
        }
        System.out.print("Enter Source & destination node ");
        int src=sc.nextInt();
        int dst=sc.nextInt();
        bfs(src,dst,graph);
    }
    public static class BPair implements Comparable<BPair>{
        int src;
        int wt;
        String psf;
        public BPair(int s,String path,int w){
            src=s;
            psf=path;
            wt=w;
        }
        public int compareTo(BPair o){
            return this.wt-o.wt;
        }
    }
    public static void bfs(int src,int dst,ArrayList<Edge> [] graph){
        PriorityQueue<BPair> qu=new PriorityQueue<>();
        qu.add(new BPair(src,""+src,0));
        boolean [] vis =new boolean[graph.length];
        while(qu.size()>0){
            BPair rem=qu.remove();
            int s=rem.src;
            int wsf=rem.wt;
            String psf=rem.psf;
            if(vis[s]==true){
                continue;
            }
            vis[s]=true;
 
            if(s==dst){
                System.out.println("Cheapest Path from "+src+" to "+dst+" :"+psf);
                System.exit(0);
            }
 
            for(Edge e:graph[s]){
                int nb=e.nbr;
                if(vis[nb]==false){
                    qu.add(new BPair(nb,psf+"->"+nb,wsf+e.wt));
                }
            }
 
        }
    }
}
