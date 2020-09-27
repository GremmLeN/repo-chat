package ru.gb.jtwo.hlesson.online;

public class Main {

    enum Colors {
        RED("#FF0000"),
        GREEN("00FF00"),
        BLUE("0000FF"),
        BLACK("000000");

        private String code;
        Colors(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }

    public static void main(String[] args) {

        System.out.println(Colors.RED.getCode());

        Colors c = Colors.BLUE;
        switch (c) {
            case RED:
                System.out.println("red as sun");
            case BLUE:
                System.out.println("blue as sea");
        }

        Colors[] colors = Colors.values();
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
    }
}
