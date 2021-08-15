//package exercise.easy;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * @author chengming.tcm
// * @version 1.0
// * @date 2020/8/31 23:29
// */
//public class KeysAndRooms {
//
//    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        List<Integer> left = new ArrayList<>();
//        List<List<Integer>> rooms = new ArrayList<>();
//        System.out.println(canVisitAllRooms(rooms));
//    }
//
//    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        if(rooms == null || rooms.size() <= 1){
//            return true;
//        }
//        Set<Integer> enterRooms = new HashSet<>();
//        enterRooms.add(0);
//        List<Integer> leftKeys = rooms.get(0);
//        int[] targetRooms = new int[rooms.size()];
//        while(leftKeys.size() != 0){
//            int key = leftKeys.get(0);
//            if(!enterRooms.contains(key) && key >= 0 && key < rooms.size()){
//                enterRooms.add(key);
//                leftKeys.addAll(rooms.get(key));
//                targetRooms[key] = 1;
//            }
//            leftKeys.remove(0);
//        }
//        for(int i=1; i < rooms.size(); i++){
//            if(targetRooms[i] == 0){
//                return false;
//            }
//        }
//        return true;
//
//    }
//
//}
