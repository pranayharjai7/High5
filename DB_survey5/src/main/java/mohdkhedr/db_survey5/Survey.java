/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mohdkhedr.db_survey5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author mohdk
 */
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    private String typeOfTemplate;
    @ManyToOne
    @JoinColumn(name = "Owner_id")
    private Data DataOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeOfTemplate() {
        return typeOfTemplate;
    }

    public void setTypeOfTemplate(String typeOfTemplate) {
        this.typeOfTemplate = typeOfTemplate;
    }

    public Data getDataOwner() {
        return DataOwner;
    }

    public void setDataOwner(Data DataOwner) {
        this.DataOwner = DataOwner;
    }

}
