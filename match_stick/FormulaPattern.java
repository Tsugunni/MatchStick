public class FormulaPattern {

    static final int receive_col = 0;
    static final int give_col = 1;
    static final int oneself_col = 2;
    public static final int[][][] relation =   {{{8},   {},     {9,6}},
                                                {{7},   {},     {}},
                                                {{},    {},     {3}},
                                                {{9},   {},     {5,2}},
                                                {{},    {},     {}},
                                                {{6,9}, {},     {3}},
                                                {{8},   {5},    {0,9}},
                                                {{},    {1},    {}},
                                                {{},    {0,6,9},{}},
                                                {{8},   {5},    {0,6}}};
    public static int[] formula = new int[3];

    static int[] rec_ori_val, giv_ori_val, slf_ori_val;
    static int rec_origin, giv_origin, slf_origin;
    static int rec_value, giv_value, slf_value;
    static int rec_location, giv_location, slf_location;
    static boolean conditions;
    static String question;

    public static String sub_receive() {
        // receiveの値とoriginの値をランダムに一つ取得
        rec_ori_val = Helper.choose_number(receive_col);
        rec_origin = rec_ori_val[0];
        rec_value = rec_ori_val[1];

        // ①上記のreceiveの値を配列に代入
        formula[0] = rec_value;

        // ②一つ値をランダムに決める
        formula[1] = (int)(Math.random()*10);

        // ③後で正しい式となる値を入れるため-1と置く
        formula[2] = -1;

        do {
            // ④配列の順番をシャッフル
            Helper.shuffle_order(formula);

            // ⑤receiveの値の場所を取得
            rec_location = Helper.find_value_location(rec_value);

            // ⑥-1にしたところを計算して代入
            conditions = Helper.create_subtraction();
        } while (conditions);

        // ⑦正しい式を問題となる式へ
        formula[rec_location] = rec_origin;
        question = formula[0] + " + " + formula[1] + " = " + formula[2];
        return question;
    }


    public static String add_give() {
        giv_ori_val = Helper.choose_number(give_col);
        giv_origin = giv_ori_val[0];
        giv_value = giv_ori_val[1];
        
        formula[0] = giv_value;
        formula[1] = (int)(Math.random()*10);
        formula[2] = -1;

        do {
            Helper.shuffle_order(formula);
            giv_location = Helper.find_value_location(giv_value);
            conditions = Helper.create_addition();
        } while (conditions);

        formula[giv_location] = giv_origin;
        question = formula[0] + " - " + formula[1] + " = " + formula[2];
        return question;
    }


    public static String receive_give() {
        rec_ori_val = Helper.choose_number(receive_col);
        rec_origin = rec_ori_val[0];
        rec_value = rec_ori_val[1];

        giv_ori_val = Helper.choose_number(give_col);
        giv_origin = giv_ori_val[0];
        giv_value = giv_ori_val[1];

        formula[0] = rec_value;
        formula[1] = giv_value;
        formula[2] = -1;

        int s;
        String sign;
        do {
            Helper.shuffle_order(formula);

            rec_location = Helper.find_value_location(rec_value);
            giv_location = Helper.find_value_location(giv_value);

            // 符号決め
            s = (int)(Math.random()*2);
            if (s == 0) {
                conditions = Helper.create_subtraction();
                sign = "-";
            } else {
                conditions = Helper.create_addition();
                sign = "+";
            }
        } while (conditions);

        formula[rec_location] = rec_origin;
        formula[giv_location] = giv_origin;
        question = formula[0] + " " + sign + " " + formula[1] + " = " + formula[2];
        return question;
    }


    public static String oneself() {
        slf_ori_val = Helper.choose_number(oneself_col);
        slf_origin = slf_ori_val[0];
        slf_value = slf_ori_val[1];

        formula[0] = slf_value;
        formula[1] = (int)(Math.random()*10);
        formula[2] = -1;

        int s;
        String sign;
        do {
            Helper.shuffle_order(formula);

            slf_location = Helper.find_value_location(slf_value);

            // 符号決め
            s = (int)(Math.random()*2);
            if (s == 0) {
                conditions = Helper.create_subtraction();
                sign = "-";
            } else {
                conditions = Helper.create_addition();
                sign = "+";
            }
        } while (conditions);

        formula[slf_location] = slf_origin;
        question = formula[0] + " " + sign + " " + formula[1] + " = " + formula[2];
        return question;
    }


    public static String sub_equal() {
        formula[0] = (int)(Math.random()*10);
        formula[1] = (int)(Math.random()*10);
        formula[2] = -1;

        do {
            Helper.shuffle_order(formula);
            conditions = Helper.create_subtraction();
        } while (conditions);

        // 等式を作成
        int a = formula[0];
        int b = formula[1];
        formula[0] = formula[2];
        formula[1] = a;
        formula[2] = b;
        question = formula[0] + " - " + formula[1] + " = " + formula[2];
        return question;
    }
}