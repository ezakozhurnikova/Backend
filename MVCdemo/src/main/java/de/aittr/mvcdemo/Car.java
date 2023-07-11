package de.aittr.mvcdemo;

public class Car {
    private Long id;
    private String mark;
    private int number;
    private static Long counter=0L;

    public Car( String mark, int number) {
        this.id = ++counter;
        this.mark = mark;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
