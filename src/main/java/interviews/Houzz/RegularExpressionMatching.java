package interviews.Houzz;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        // assumption: (1) s and p not empty (2) * won't be the first element, and won't be consecutive * s
        /*
        cur = p.charAt(i)
        case I: cur is not . or *, see if there's exact match in s
        case II: cur is .

        case III: cur = '*'
        */
        boolean[] res = {false};
        dfs(s, 0, p, 0, res);
        return res[0];
    }

    // invariant: p[pIdx] is not '*'
    private void dfs(String s, int sIdx, String p, int pIdx, boolean[] res) {
        if (res[0]) {
            return;
        }
        if (sIdx >= s.length() && pIdx >= p.length()) {
            res[0] = true;
            return;
        }
        if (sIdx >= s.length() || pIdx >= p.length()) {
            return;
        }
        if (pIdx == p.length() - 1 || p.charAt(pIdx + 1) != '*') {
            if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.') {
                dfs(s, sIdx + 1, p, pIdx + 1, res);
            }
        } else {
            while (sIdx < s.length() && s.charAt(sIdx) == p.charAt(pIdx)) {
                dfs(s, sIdx, p, pIdx + 2, res);
                sIdx++;
            }
            dfs(s, sIdx, p, pIdx + 2, res);
        }
    }
}
