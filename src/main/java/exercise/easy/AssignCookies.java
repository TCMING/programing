package exercise.easy;

/**
 * 455
 * @Author tianchengming
 * @Date 2020年12月25日 10:18
 * @Version 1.0
 */
public class AssignCookies {

    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] g = {10,9,8,7};
        int[] s = {10,9,8,7};
        System.out.println(assignCookies.findContentChildren(g,s));
    }


    public int findContentChildren(int[] g, int[] s) {
        if(s == null || s.length == 0){
            return 0;
        }
        for(int i=0; i < s.length; i++){
            int index = findChild(g,s[i]);
            if(index >= 0){
                s[i] *= -1;
                g[index] *= -1;
            }
        }
        int count = 0;
        for(int size : s){
            if(size < 0){
                count++;
            }
        }
        return count;
    }

    /**
     * 找到尺寸下，胃口最大的孩子
     * @param g
     * @param size
     * @return
     */
    private int findChild(int[] g,int size){
        int max = -1;
        int index = -1;
        for(int i=0; i < g.length; i++){
            if(size >= g[i] && g[i] >= 0){
                if(max < g[i]){
                    max = g[i];
                    index = i;
                }
            }
        }
        return index;
    }

}
