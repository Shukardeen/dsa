class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // graph of flights
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        for(int[] f: flights) {
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }

        // queue - stores [stops, node, distance/cost]
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, src, 0});

        // distance array (or cost array)
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int stops = curr[0], node = curr[1], cost = curr[2];

            if(stops > k) continue;

            for(int[] nb: graph.get(node)) {
                int nNode = nb[0];
                int nCost = nb[1];

                if(nCost+cost < distance[nNode]) {
                    distance[nNode] = nCost+cost;
                    q.offer(new int[]{stops+1, nNode, nCost+cost});
                }
            }
        }

        if(distance[dst] == Integer.MAX_VALUE) return -1;
        return distance[dst];
    }
}