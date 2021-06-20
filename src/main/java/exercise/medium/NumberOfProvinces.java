package exercise.medium;

import java.util.*;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *[[],[],[],[]]
 * @Author tianchengming
 * @Date 2021年1月7日 20:10
 * @Version 1.0
 */
public class NumberOfProvinces {

    public static void main(String[] args) {

        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(numberOfProvinces.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0 || isConnected[0].length == 0){
            return 0;
        }
        List<List<Integer>> provices = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < isConnected.length; i++){
            for(int j=0; j < isConnected[i].length; j++){
                if(isConnected[i][j] != 0){
                    if(map.get(i) == null && map.get(j) == null){
                        List<Integer> list = new LinkedList<>();
                        list.add(i);
                        list.add(j);
                        provices.add(list);
                        map.put(i,provices.size()-1);
                        map.put(j,provices.size()-1);
                    }else if(map.get(i) == null && map.get(j) != null){
                        provices.get(map.get(j)).add(i);
                        map.put(i,map.get(j));
                    }else if(map.get(j) == null && map.get(i) != null){
                        provices.get(map.get(i)).add(j);
                        map.put(j,map.get(i));
                    }else if(map.get(j) != null && map.get(i) != null){
                        if((int)map.get(i) != (int)map.get(j)){
                            int max = Math.max(map.get(i),map.get(j));
                            int min = Math.min(map.get(i),map.get(j));
                            List<Integer> list = provices.get(max);
                            for(int city : list){
                                map.put(city,min);
                            }
                        }
                    }
                }
            }
        }
        Set<Integer> finalProvice = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            finalProvice.add(entry.getValue());
        }
        return finalProvice.size();
    }
}
