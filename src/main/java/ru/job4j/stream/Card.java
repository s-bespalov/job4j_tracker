package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }

    public static void main(String[] args) {
        List<Card> deck = Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> new Card(s, v)))
                .toList();
        deck.forEach(System.out::println);
    }
}
