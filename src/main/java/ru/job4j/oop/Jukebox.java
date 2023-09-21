package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("""
                    Пусть бегут неуклюже
                    Пешеходы по лужам
                    А вода по асфальту рекой
                    И неясно прохожим
                    В этот день непогожий
                    Почему я веселый такой?""");
            case 2 -> System.out.println("""
                    Спят усталые игрушки, книжки спят.
                    Одеяла и подушки ждут ребят.
                    Даже сказка спать ложится,
                    Чтобы ночью нам присниться.
                    Ты ей пожелай:
                    Баю-бай.""");
            default -> System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox melodia = new Jukebox();
        melodia.music(1);
        melodia.music(2);
        melodia.music(10);
    }
}
