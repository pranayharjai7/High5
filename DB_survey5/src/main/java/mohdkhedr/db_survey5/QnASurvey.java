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
public class QnASurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String questions;
    private String answers;
    @ManyToOne
    @JoinColumn(name = "QnASurvey_id")
    Survey SurveyTemplate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Survey getSurveyTemplate() {
        return SurveyTemplate;
    }

    public void setSurveyTemplate(Survey SurveyTemplate) {
        this.SurveyTemplate = SurveyTemplate;
    }
}
