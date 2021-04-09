/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mohdkhedr.db_survey5;

import java.util.List;

/**
 *
 * @author mohdk
 */
public interface QnASurveyDAO extends AutoCloseable{
    public void saveQnASurvey(QnASurvey qna);
    public void deleteQnASurvey(QnASurvey qna);
    public void updateQnASurvey(QnASurvey qna);
    public List<QnASurvey> getQnASurvey();
}
