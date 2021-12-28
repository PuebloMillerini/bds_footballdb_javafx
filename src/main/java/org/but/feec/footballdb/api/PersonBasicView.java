package org.but.feec.footballdb.api;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonBasicView {
    private LongProperty id = new SimpleLongProperty();
    private StringProperty city = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty givenName = new SimpleStringProperty();
    private StringProperty familyName = new SimpleStringProperty();
    private StringProperty nickname = new SimpleStringProperty();

    public Long getId() {
        return idProperty().get();
    }

    public void setId(Long id) {
        this.idProperty().setValue(id);
    }

    public String getCity() {
        return cityProperty().get();
    }

    public void setCity(String city) {
        this.cityProperty().setValue(city);
    }

    public String getEmail() {
        return emailProperty().get();
    }

    public void setEmail(String email) {
        this.emailProperty().setValue(email);
    }

    public String getGivenName() {
        return givenNameProperty().get();
    }

    public void setGivenName(String givenName) {
        this.givenNameProperty().setValue(givenName);
    }

    public String getFamilyName() {
        return familyNameProperty().get();
    }

    public void setFamilyName(String familyName) {
        this.familyNameProperty().setValue(familyName);
    }

    public String getNickname() {
        return nicknameProperty().get();
    }

    public void setNickname(String nickname) {
        this.nicknameProperty().set(nickname);
    }

    public LongProperty idProperty() {
        return id;
    }

    public StringProperty cityProperty() {
        return city;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty givenNameProperty() {
        return givenName;
    }

    public StringProperty familyNameProperty() {
        return familyName;
    }

    public StringProperty nicknameProperty() {
        return nickname;
    }

}
