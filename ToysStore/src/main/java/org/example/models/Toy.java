package org.example.models;

public class Toy {
    private int Id;
    private String Title;
    private int Count;
    private double Frequency;

    public Toy(){
        this(0,"",0);
    }
    public Toy(int id, String title, int count) {
        Id = id;
        Title = title;
        Count = count;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public double getFrequency() {
        return Frequency;
    }

    public void setFrequency(double frequency) {
        Frequency = frequency;
    }

    @Override
    public String toString() {
        return "Название - " + this.Title + " Количество - " + this.Count + " Шанс выпадения - " + this.Frequency*100 + "%";
    }
}
