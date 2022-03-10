package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
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
        return "Card + " + value + " of " + suit;
    }

    public static void main(String[] args) {
        List<Card> deck = Stream.of(Value.values())
                .map(v -> {
                    return Stream.of(Suit.values())
                            .map(s -> new Card(s, v))
                            .collect(Collectors.toList());
                })
                .flatMap(cards -> cards.stream())
                .collect(Collectors.toList());
        deck.forEach(System.out::println);
    }
}
