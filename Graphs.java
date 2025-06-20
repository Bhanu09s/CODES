import java.util.*;
import java.util.LinkedList;
class Graphs{
    static class Edge{
        int src;
        int dest;
        // int wt;

        // public Edge(int s, int d, int w){
        //     this.src = s;
        //     this.dest = d;
        //     this.wt = w;
        // }
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        // graph[0].add(new Edge(0,2,2));
        // graph[1].add(new Edge(1,2,10));
        // graph[1].add(new Edge(1,3,0));
        // graph[2].add(new Edge(2,0,2));
        // graph[2].add(new Edge(2,1,10));
        // graph[2].add(new Edge(2,3,-1));
        // graph[3].add(new Edge(3,1,0));
        // graph[3].add(new Edge(3,2,-1));
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }

    public static void bfs(ArrayList<Edge> graph[],int V){
    //public static void bfs(ArrayList<Edge> graph[],int V, boolean vis[], int start)

        Queue<Integer> q = new LinkedList<>();

        // we remove this boolean vis[] when we work with discrete graphs
        // as we have already defined this in the main function
        boolean vis[] = new boolean[V];

        // the starting point will be different for every discrete graph
        // this is why we need to tell the code the starting point
        // q.add(start)
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr]=true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        if(vis[curr] == true){
            return;
        }
        System.out.print(curr+" ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            dfs(graph,e.dest,vis);
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar){
        if(curr==tar){
            System.out.println(path);
            return;
        }

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                printAllPath(graph, vis, e.dest, path+e.dest, tar);
                vis[curr] = false;
            }
        }
    }

    public static void main(String args[]){ // O(V+E)--> time complexity both DFS and BFS
        // int V = 4;
        int V = 7;
        /*
          1 ------ 3
         /         | \
        0          |  5 --- 6
         \         | /
          2 ------ 4
         */
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        // we dont call bfs function here we will call this inside the loop
        // when dealing with multiple discrete graph
        bfs(graph,V);
        
        System.out.println();
        // //print 2's neighbours
        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest+" "+e.wt);
        // }

        // // If we need to print the vertices For two or more discrete graphs
        // boolean vis[] = new boolean[V];
        // for(int i=0;i<V;i++){
        //     if(vis[i]==false){
        //         bfs(graph,V,vis,i);
        //     }
        // }

        boolean vis[] = new boolean[V];
        dfs(graph, 0, vis);

        // // for the discrete graph and we want to do the dfs
        // // we write the same loop as we write in the bfs i.e
        // boolean vis[] = new boolean[V];
        // for(int i=0;i<V;i++){
        //     if(vis[i]==false){
        //         dfs(graph, 0, vis);
        //     }
        // }

        System.out.println();

        int src = 0;
        int tar = 5;
        printAllPath(graph, new boolean[V], src, "0", tar);
    }
}