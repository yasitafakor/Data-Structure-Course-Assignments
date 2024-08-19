import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Maain {

    final static int[] pred = new int[200000];
    final static int[] dist = new int[200000];
    final static ArrayList<Integer>[] adj = new ArrayList[200000];

    final static LinkedList<Integer> queue = new LinkedList<Integer>();


    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 200000; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        int T = scanner.nextInt();

        for(int r = 0; r < T; r++){

            int vertex = scanner.nextInt();
            int edge = scanner.nextInt();
            int end = scanner.nextInt();
            int start = scanner.nextInt();

            for(int i = 0; i < vertex+1; i++){
                adj[i].clear();
            }

            for(int i = 0; i < edge; i++){

                addEdge(adj, scanner.nextInt(), scanner.nextInt());
            }
            printShortestDistance(adj, start, end, vertex);
        }
    }

    private static void addEdge(ArrayList<Integer>[] adj, int i, int j)
    {
        adj[i].add(j);
    }

    private static void printShortestDistance(ArrayList<Integer>[] adj, int s, int dest, int v)
    {

        Arrays.fill(pred,0);
        Arrays.fill(dist,0);

        if (!BFS(adj, s, dest, v, pred, dist)) {
            System.out.println("-1");
            return;
        }


        // Print distance
        System.out.println(dist[dest]);

    }

    private static boolean BFS(ArrayList<Integer>[] adj, int src, int dest, int v, int pred[], int dist[])
    {

        queue.clear();
        boolean visited[] = new boolean[200000];

        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.pop();
            for (int i = 0; i < adj[u].size(); i++) {
                if (!visited[adj[u].get(i)]) {
                    visited[adj[u].get(i)] = true;
                    dist[adj[u].get(i)] = dist[u] + 1;
                    pred[adj[u].get(i)] = u;
                    queue.add(adj[u].get(i));


                    if (adj[u].get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
