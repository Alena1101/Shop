package com.alena;

import java.util.Objects;

public class Toy {
    private final int id;
    private final String name;
    private  int count;
    private int frequency ;

    public Toy(int id, String name, int count, int frequency) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Toy{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", count=").append(count);
        sb.append(", frequency=").append(frequency);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id && count == toy.count && frequency == toy.frequency && Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count, frequency);
    }
}
