package Survey5.model;

import javax.persistence.*;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int questionNumber;

    @Column(nullable = false)
    private String question;

    @ManyToOne
    private Survey surveyTemplate;

    @ManyToOne
    private Data answeredByUser;

    public Questions(int questionNumber, String question, Survey surveyTemplate, Data answeredByUser) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.surveyTemplate = surveyTemplate;
        this.answeredByUser = answeredByUser;
    }


    public Survey getSurveyTemplate() {
        return surveyTemplate;
    }

    public void setSurveyTemplate(Survey surveyTemplate) {
        this.surveyTemplate = surveyTemplate;
    }

    public Questions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Data getAnsweredByUser() {
        return answeredByUser;
    }

    public void setAnsweredByUser(Data answeredByUser) {
        this.answeredByUser = answeredByUser;
    }
}
