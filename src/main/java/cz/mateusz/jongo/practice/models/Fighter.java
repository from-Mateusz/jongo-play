package cz.mateusz.jongo.practice.models;

import cz.mateusz.jongo.practice.database.EntityModel;
import cz.mateusz.jongo.practice.database.annotations.MongoDocument;
import cz.mateusz.jongo.practice.database.annotations.MongoDocumentEntityIdType;

import java.util.ArrayList;
import java.util.List;

@MongoDocument(idType = MongoDocumentEntityIdType.LONG,
                collectionName = "fighters")
public class Fighter extends EntityModel {

    private FullName name;

    private String pseudo;

    private Record record;

    private List<Fight> fights;

    private Fighter() {}

    public Fighter(FighterCreator fighterCreator) {
        this.name = fighterCreator.name;
        this.pseudo = fighterCreator.pseudo;
        this.record = fighterCreator.record;
        this.fights = fighterCreator.fights;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Fight> getFights() {
        return fights;
    }

    public void setFights(List<Fight> fights) {
        this.fights = fights;
    }



    public final static class FighterCreator {

        private FullName name;

        private String pseudo;

        private Record record;

        private List<Fight> fights = new ArrayList<>();

        public FighterCreator(FullName name, String pseudo) {
            this.name = name;
            this.pseudo = pseudo;
        }

        public FighterCreator withRecord(Record record) {
            this.record = record;
            return this;
        }

        public FighterCreator withFight(Fight fight) {
            fights.add(fight);
            return this;
        }
    }
}
