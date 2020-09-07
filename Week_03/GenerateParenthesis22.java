import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GenerateParenthesis22
 * @Description TODO
 * @Date 2020/9/7 22:53
 * @Created by Michelangelo-apple
 */
public class GenerateParenthesis22 {
    //不能用StringBuilder sb 作为参数，共享内容
    public List<String> generateParenthesis(int n) {
//        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        _generateParenthesis(n,n,"",result);
        return  result;
    }

    public void _generateParenthesis(int left, int right, String sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb);
            return;
        }
        if (left > 0) {
//            sb.append("(");
            _generateParenthesis(left - 1,right,sb + "(",result);
        }
        if (right > 0 && left < right) {
//            sb.append(")");
            _generateParenthesis(left,right - 1,sb +")",result);
        }
    }
}
