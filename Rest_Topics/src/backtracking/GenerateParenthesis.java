package backtracking;


import java.util.ArrayList;
import java.util.List;

/**Problem: Leetcode - 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<String>();
        helper(n, new StringBuilder(), 0, ans);
        return ans;
    }
    private void helper(int n, StringBuilder selected, int index, List<String>ans){
        if(selected.length()==n*2) {
            ans.add(selected.toString());
            return;
        }
        for(int i=selected.length()/2;i<=selected.length();i++){
            selected.insert(i,"()");
            helper(n, selected, index+1, ans);
            selected.delete(i,i+2);
        }

    }
}
