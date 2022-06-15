package com.example.quizaire;

public class answerclass {

    private int question_id, option_A, option_B, option_C, option_D, answer_id;

    public answerclass(int question_ide, int option_a, int option_b, int option_c, int option_d, int answer_ide){

        question_id = question_ide;
        option_A = option_a;
        option_B = option_b;
        option_C = option_c;
        option_D = option_d;
        answer_id = answer_ide;

    }

    public int getQuestion_id() {

        return question_id;
    }

    public int getOption_A() {

        return option_A;
    }

    public int getOption_B() {

        return option_B;
    }

    public int getOption_C() {

        return option_C;
    }

    public int getOption_D() {

        return option_D;
    }

    public int getAnswer_id() {

        return answer_id;
    }
}
