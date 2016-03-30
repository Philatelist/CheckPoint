package com.slavyanin.example.checkpoint.checkpoint;


public class Check {

    private double mark;
    private int question;
    private String nameCheck;

    public Check(double mark, int question, String nameCheck) {
        this.mark = mark;
        this.question = question;
        this.nameCheck = nameCheck;
    }

    public void execute() {
        System.out.println("Hello world!");

    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getNameCheck() {
        return nameCheck;
    }

    public void setNameCheck(String nameCheck) {
        this.nameCheck = nameCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Check check = (Check) o;

        if (Double.compare(check.mark, mark) != 0) return false;
        if (question != check.question) return false;
        return !(nameCheck != null ? !nameCheck.equals(check.nameCheck) : check.nameCheck != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(mark);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + question;
        result = 31 * result + (nameCheck != null ? nameCheck.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Check{" +
                "mark=" + mark +
                ", question=" + question +
                ", nameCheck='" + nameCheck + '\'' +
                '}';
    }
}
