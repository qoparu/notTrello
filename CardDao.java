package com.qoparu.dao;

import com.qoparu.model.Card;
import java.util.Optional;

public interface CardDao {
    void save(Card card);
    Optional<Card> findById(String id);
    void delete(String id);
}
