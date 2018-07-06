package SerieFibonacci;

public class LogicaFibonacci {
    public String[][] solve(int n) {
        String answer[][] = new String[n][5];
        int fn = 0, f0 = 0, f1 = 1;
        
        answer[0][0] = "" + 1;
        answer[1][0] = "" + 2;
        answer[0][1] = "" + f0;
        answer[1][1] = "" + f1;
        for(int i = 2; i < n; i++) {
            fn = f0 + f1;
            answer[i][0] = "" + (i+1);
            answer[i][1] = "" + fn;
            f0 = f1;
            f1 = fn;
        }
        return answer;
    }
}
