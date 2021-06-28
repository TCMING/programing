package exercise.medium;

import java.util.Arrays;

/**
 * @Author tianchengming
 * @Date 2021年6月25日 21:57
 * @Version 1.0
 */
public class WordSearch {

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = {{'A'}};
        solution79.exist(board,"A");
    }

}


class Solution79 {
    public boolean exist(char[][] board, String word) { int[] visit = new int[board.length * board[0].length];
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                Arrays.fill(visit,0);
                if(backTrack(word,0,board,i,j,visit)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(String word,int curWord,char[][] board,int i,int j,int[] visit){
        if(curWord == word.length()){
            return true;
        }
        if(i < 0 || j< 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(visit[i*board[0].length + j] != 0){
            return false;
        }
        if(word.charAt(curWord) != board[i][j]){
            return false;
        }
        visit[i*board[0].length + j] = 1;
        return backTrack(word,curWord+1,board,i-1,j,visit)
                || backTrack(word,curWord+1,board,i,j-1,visit)
                || backTrack(word,curWord+1,board,i,j+1,visit)
                || backTrack(word,curWord+1,board,i+1,j,visit);

    }
}
