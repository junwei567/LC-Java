package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class MaximalNetworkRank {
    public int getMaximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> networks = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            networks.put(i, new HashSet<>());
        }
        // populate the hashsets in networks hashmap
        for (int i = 0; i < roads.length; i++) {
            networks.get(roads[i][0]).add(roads[i][1]);
            networks.get(roads[i][1]).add(roads[i][0]);
        }
        // calculate the max network rank
        int maxRank = 0;
        for (int i = 0; i < n-1; i ++) {
            for (int j = i+1; j < n; j ++) {
                int tmp = 0;
                tmp += (networks.get(i).size() + networks.get(j).size());
                // if road is connected between cities, avoid double counting
                if (networks.get(i).contains(j)) {
                    tmp --;
                }
                maxRank = Math.max(maxRank, tmp);
            }
        }
        return maxRank;
    }

    public static void main(String[] args) {
        int[][] array = {{0,1}, {0,3}, {1,2}, {1,3}};
        MaximalNetworkRank maximalNetworkRank = new MaximalNetworkRank();
        System.out.println(maximalNetworkRank.getMaximalNetworkRank(array.length, array));
    }
}
