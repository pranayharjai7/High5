package Survey5.model;

import java.util.List;

public interface SurveysDaoInterface extends AutoCloseable{
    public void setSurvey(Survey survey);
    public void deleteSurvey(Survey survey);
    public void updateSurvey(Survey survey);
    public List<Survey> getAllSurveys();
    public List<Survey> getUserSurveys(Data data);
}
