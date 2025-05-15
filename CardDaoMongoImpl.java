package com.qoparu.dao;

import com.mongodb.client.MongoCollection;
import com.qoparu.model.Card;
import org.bson.Document;

public class CardDaoMongoImpl implements CardDao {
    private final MongoCollection<Document> collection;

    public CardDaoMongoImpl(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    @Override
    public void save(Card card) {
        Document doc = new Document("_id", card.getId())
                .append("title", card.getTitle());
        collection.insertOne(doc);
    }
}
