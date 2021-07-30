import java.util.Arrays;

public class BellmanFordAlgorithm {

    public int[] bellmanFordAlgo(int[][] graph, int v, int source) {

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[v] = 0;

        for(int count = 0; count < (v-1); count++) {
            for(int i=0; i<v; i++) {
                for(int j=0; j<v; j++) {
                    if(dist[i] != Integer.MAX_VALUE && dist[j] > dist[i] + graph[i][j])
                        dist[j] = dist[i] + graph[i][j];
                }
            }
        }

        for(int i=0; i<v; i++)
            for(int j=0; j<v; j++)
                if(dist[j] > dist[i] + graph[i][j])
                    System.out.println("negative weight cycle");
                    // throw exception here

        return dist;
    }

}
