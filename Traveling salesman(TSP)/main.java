import java.io.*;
import java.util.*;
 
public class main {
   static class Edge {
      int src;
      int nbr;
      int wt;
 
      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
    static class Tpair implements Comparable<Tpair>{
        String asf;
        int wsf;
        Tpair(String path,int weight) {
            asf=path;
            wsf=weight;
        }
        public int compareTo(Tpair o){
            return this.wsf-o.wsf;
        }
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter number of vertices");
      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }
      System.out.println("Enter number of edges");
      int edges = Integer.parseInt(br.readLine());
      System.out.println("Enter Edge src,dst and weight");
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      System.out.println("Enter source/start vertex");
      int src = Integer.parseInt(br.readLine());
      boolean []vis=new boolean[vtces];
    pq=new PriorityQueue<>();
    TSP(graph,vis,src,src,src+"",1,0);
    Tpair sol=pq.remove();
    System.out.println("Optimal solution for TSP from Source "+src+" is\nPath : "+sol.asf+" \nweight : "+sol.wsf);
   }
   public static boolean isEdge(ArrayList<Edge> [] graph,int src,int dest){
       for(Edge e:graph[src]){
           int nbr=e.nbr;
           if(nbr==dest){
               return true;
           }
       }
       return false;
   }  
   static PriorityQueue<Tpair> pq;
   public static void TSP(ArrayList<Edge> [] graph ,boolean [] vis,int src,int Osrc,String asf,int visvtx,int wsf){
       if(visvtx==graph.length){
           if(isEdge(graph,Osrc,src)){
            pq.add(new Tpair(asf+"->"+Osrc,wsf));
           }
           return;
       }
       
       vis[src]=true;
       for(Edge e: graph[src]){
           int nbr=e.nbr;
           if(vis[nbr]==false){
             TSP(graph,vis,nbr,Osrc,asf+"->"+nbr,visvtx+1,wsf+e.wt);  
           }
       }
      vis[src]=false;
   }
}
