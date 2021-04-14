package Survey5.model;

import java.util.List;

public interface QnADaoInterface extends AutoCloseable{
    public void setQnA(QnA qna);
    public void deleteQnA(QnA qna);
    public void updateQnA(QnA qna);
    public List<QnA> getAllQnA();
    public List<QnA> getSurveyQnA(Survey survey);
}
