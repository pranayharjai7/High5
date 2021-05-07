package Survey5.model;

import javax.persistence.*;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String typeOfTemplate;
    private String title;

    @ManyToOne
    private Data Owner;

    public Data getOwner() {
        return Owner;
    }

    public void setOwner(Data owner) {
        Owner = owner;
    }


    public String getTypeOfTemplate() {
        return typeOfTemplate;
    }

    public void setTypeOfTemplate(String typeOfTemplate) {
        this.typeOfTemplate = typeOfTemplate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Survey() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

