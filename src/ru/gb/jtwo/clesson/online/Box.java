package ru.gb.jtwo.clesson.online;

import java.util.Objects;

public class Box implements Comparable/*<Box>*/ {
    int height;
    int width;
    int depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return String.format("Box(%d,%d,%d)", width, height, depth);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Box)) return false;
        Box b = (Box) obj;
        return this.width == b.width && this.height == b.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    private int square() {
        return height * width;
    }

    @Override
    public int compareTo(Object o) {
        Box box = (Box) o;
        int sq = square();
        int boxSq = box.square();
        if (sq < boxSq) {
            return -1;
        } else if (sq > boxSq) {
            return 1;
        } else {
            return 0;
        }
    }

//    @Override
//    public int compareTo(Box o) {
//        return (o == this) ? 0 : square() - o.square();
//    }
//

}
