import java.util.*;

public class Main {

    public static int vector,edge;
    static long result = 0;
    static long  pow = 0;
    static int[] value = new int[2000];
    static int[] mark = new int[2000];
    static int[][] checked = new int[2000][2000];
    static ArrayList<Integer>[] adj = new ArrayList[2000];

    static AbstractMap.SimpleEntry<Integer, Integer> pair;

    static PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer> > q =
            new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());


    public static void BFS(int s){

        pow = result;
        Arrays.fill(mark,0);

        q.add(new AbstractMap.SimpleEntry<>(value[s],s));
        mark[s] = 1;

        assert q.peek() != null;
        int v = q.peek().getValue();
        q.poll();

        for (int u: adj[v]) {
            if(mark[u] != 1){
                q.add(new AbstractMap.SimpleEntry<>(value[u],u));
                mark[u] = 1;
            }
        }

        while(q.size() != 0){
            v = q.peek().getValue();
            q.poll();
            if(pow > value[v])
                pow += value[v];
            else{
                result += value[v] - pow + 1;
                pow += value[v] - pow + value[v] + 1;
            }
            for (int u : adj[v]) {
                if(mark[u] != 1){
                    mark[u] = 1;
                    q.add(new AbstractMap.SimpleEntry<>(value[u],u));
                }
            }

        }
    }

    public static void main(String[] args)
            throws NullPointerException{

        Scanner scan = new Scanner(System.in);

        vector = scan.nextInt();
        edge = scan.nextInt();

        for (int i = 0; i < 2000; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < vector; i++)
            value[i+1] = scan.nextInt();

        for(int i = 0; i < edge; i++){

            int u = scan.nextInt();
            int v = scan.nextInt();

            if(checked[u][v] != 1){

                adj[u].add(v);
                adj[v].add(u);
                checked[u][v] = 1;
                checked[v][u] = 1;
            }

        }

        for (int i = 1; i <= vector ; i++) {
            result = value[i];
            BFS(i);
            System.out.print(result - value[i]);
            System.out.print(" ");
        }

    }
}