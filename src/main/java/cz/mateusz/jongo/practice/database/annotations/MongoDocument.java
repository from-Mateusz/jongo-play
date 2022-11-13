package cz.mateusz.jongo.practice.database.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MongoDocument {
    MongoDocumentEntityIdType idType();

    String collectionName();
}
