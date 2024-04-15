package org.example;
import java.lang.String;
public class User {
    private long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters et setters (ou méthodes d'accès) pour les attributs id et name

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Vous n'avez pas besoin de redéfinir la méthode getClass(), elle est déjà définie dans la classe Object
}
