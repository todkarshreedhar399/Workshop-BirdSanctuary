package com.bl.birdsanctuary;

import java.util.Objects;

public class Bird {

    enum Color{
        RED,BLACK_WHITE,GREY,BLACK,WHITE,GREEN
    }

    String id;
    Color color;
    String name;
    boolean canFly;
    boolean canSwim;

    @Override
    public String toString() {
        return "Bird [id=" + id + ", color=" + color + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bird other = (Bird) obj;
        return Objects.equals(id, other.id);
    }


    public void eat(){
        System.out.println(name +" can eat");}

    public void fly(){
        System.out.println(name +" can fly");
    }

    public void swim(){
        System.out.println(name+" can swim");}
}
