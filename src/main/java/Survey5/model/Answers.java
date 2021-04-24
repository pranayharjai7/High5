package Survey5.model;

import javax.persistence.*;


@Entity
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String answersType;
    @Column(nullable = false)
    private String AnswerText;
    @ManyToOne
    private Questions question;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswersType() {
        return answersType;
    }

    public void setAnswersType(String answersType) {
        this.answersType = answersType;
    }

    public String getAnswerText() {
        return AnswerText;
    }

    public void setAnswerText(String answerText) {
        AnswerText = answerText;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }
}
