package Survey5.model;

import java.util.List;

public interface AnswersDaoInterface extends AutoCloseable{
    public void setAnswers(Answers ans);
    public void deleteAnswers(Answers ans);
    public void updateAnswers(Answers ans);
    public List<Answers> getAllAnswers();
    public List<Answers> getQuestionAnswers(Questions questions);
    
}
