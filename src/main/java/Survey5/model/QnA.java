package Survey5.model;

import javax.persistence.*;

@Entity
public class QnA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String question;

    @Column
    private String answer;


    @ManyToOne
    private Survey surveyTemplate;

    public Survey getSurveyTemplate() {
        return surveyTemplate;
    }

    public void setSurveyTemplate(Survey surveyTemplate) {
        this.surveyTemplate = surveyTemplate;
    }

    public QnA() {
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
