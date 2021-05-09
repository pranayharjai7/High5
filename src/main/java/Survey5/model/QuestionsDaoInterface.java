package Survey5.model;

import java.util.List;

public interface QuestionsDaoInterface extends AutoCloseable{
    public void setQuestions(Questions questions);
    public void deleteQuestions(Questions questions);
    public void updateQuestions(Questions questions);
    public List<Questions> getAllQuestions();
    public List<Questions> getSurveyQuestions(Survey survey);
    public List<Questions> getUserQuestions(Data userdata);
    //public List<Questions> getUserSurveyQuestions(Data userdata,Survey survey);
}
