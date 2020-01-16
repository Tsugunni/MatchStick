public class Matchstick {
    public static void main(String[] args) {
        int pattern;
        String formula_pattern = "";
        String question;
        int q_num = 15;

        System.out.println("問題：マッチ棒で作られた以下の式を、マッチ棒を一本だけ動かして正しい式を作りなさい。");

        for (int i = 1; i <= q_num; i++) {
            pattern = (int)(Math.random()*5) + 1;

            switch (pattern) {
                case 1:
                    formula_pattern = FormulaPattern.sub_receive();
                    break;
                case 2:
                    formula_pattern = FormulaPattern.add_give();
                    break;
                case 3:
                    formula_pattern = FormulaPattern.receive_give();
                    break;
                case 4:
                    formula_pattern = FormulaPattern.oneself();
                    break;
                case 5:
                    formula_pattern = FormulaPattern.sub_equal();
                    break;
            }
            question = "(" + i + ") " + formula_pattern + "  [" + pattern + "]";
            System.out.println(question);
        }
    }
}