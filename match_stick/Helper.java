public class Helper extends FormulaPattern {

    public static int[] choose_number(int col) {
        int el = 0;
        int original;

        do {
            original = (int)(Math.random()*10);
            if (relation[original][col].length == 2) {
                el = (int)(Math.random()*2);
            } else if (relation[original][col].length == 3) {
                el = (int)(Math.random()*3);
            }
        } while (relation[original][col].length == 0);

        int[] ori_val = {original, relation[original][col][el]};
        return ori_val;
    }

    public static int[] shuffle_order(int[] formula) {
        int rnd;
        int w;
        for ( int i = 0; i < formula.length; ++ i ) {
            // 0～(配列aryの個数-1)の乱数を発生
            rnd = (int)( Math.random() * (double)formula.length );

            // formula[i]とformula[rnd]を入れ替える
            w = formula[i];
            formula[i] = formula[rnd];
            formula[rnd] = w;    
        }
        return formula;
    }

    public static int find_value_location(int v) {
        int i;
        for (i = 0; i < formula.length; i++)
            if (formula[i] == v)
                break;
        return i;
    } 

    public static boolean create_addition() {
        if (formula[2] >= formula[0] && formula[2] >= formula[1]) {
            if (formula[0] >= 0)
                formula[1] = formula[2] - formula[0];
            else
                formula[0] = formula[2] - formula[1];
        } else if (formula[2] == -1) {
            formula[2] = formula[0] + formula[1];
        }
        boolean conditions = (formula[0] < formula[2] && formula[2] < formula[1]) || (formula[1] < formula[2] && formula[2] < formula[0]);
        return conditions;
    }

    public static boolean create_subtraction() {
        if (formula[0] >= formula[1] && formula[0] >= formula[2]) {
            if (formula[1] >= 0)
                formula[2] = formula[0] - formula[1];
            else
                formula[1] = formula[0] - formula[2];
        } else if (formula[0] == -1) {
            formula[0] = formula[1] + formula[2];
        }
        boolean conditions = (formula[1] < formula[0] && formula[0] < formula[2]) || (formula[2] < formula[0] && formula[0] < formula[1]);
        return conditions;
    }
}