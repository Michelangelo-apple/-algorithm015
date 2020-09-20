import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveNQueens {
  public List<List<String>> solveNQueens(int n) {
    int[] queens = new int[10];//下标代表行数 值代表皇后所在的列
    Arrays.fill(queens,-1);
    Set<Integer> clos = new HashSet<>();
    Set<Integer> sum = new HashSet<>();
    Set<Integer> sub = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    dfs(result,n,queens,0,clos,sum,sub);
    return result;
  }

  private void dfs(List<List<String>> result,int n, int[] queens, int row,Set<Integer> clos, Set<Integer> sum, Set<Integer> sub) {
      if (row == n) {
        List<String> board = generateBoard(queens,n);
        result.add(board);
        return;
      }

        for (int i = 0; i < n; i++) {
          int dataSum = row + i;
          int dataSub = row - i;
          if (clos.contains(i)) {
            continue;
          }
          if (sub.contains(dataSub)) {
            continue;
          }
          if (sum.contains(dataSum)) {
            continue;
          }
          queens[row] = i;
          clos.add(i);
          sub.add(dataSub);
          sum.add(dataSum);

          dfs(result,n,queens,row+1,clos,sum,sub);

          queens[row] = -1;
          clos.remove(i);
          sub.remove(dataSub);
          sum.remove(dataSum);

      }
  }

  private List<String> generateBoard(int[] queens, int n) {
    List<String> board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      char[] chars = new char[n];
      Arrays.fill(chars, '.');
      chars[queens[i]] = 'Q';
      board.add(new String(chars));
    }
    return board;
  }
}
