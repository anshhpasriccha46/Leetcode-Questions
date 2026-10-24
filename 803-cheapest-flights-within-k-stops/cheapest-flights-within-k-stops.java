import java.util.*;

class city {
    int node, price, stops;

    city(int a, int b, int c) {
        node = a;
        price = b;
        stops = c;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] f : flights)
            g.get(f[0]).add(new int[]{f[1], f[2]});

        // fewest flights used when each city was polled
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        PriorityQueue<city> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        pq.add(new city(src, 0, 0));

        while (!pq.isEmpty()) {
            city curr = pq.poll();

            // cheapest valid path to dst, since pq polls by price
            if (curr.node == dst) return curr.price;

            // no flights left from here (stops counts flights taken)
            if (curr.stops > k) continue;

            // dominated: this city was already polled cheaper with fewer or equal flights
            if (curr.stops >= minStops[curr.node]) continue;
            minStops[curr.node] = curr.stops;

            for (int[] a : g.get(curr.node))
                pq.add(new city(a[0], curr.price + a[1], curr.stops + 1));
        }

        return -1;
    }
}