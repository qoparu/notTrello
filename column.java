package com.qoparu.model;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private String id;
    private String name;
    private List<Card> cards = new ArrayList<>();

    public Column(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
