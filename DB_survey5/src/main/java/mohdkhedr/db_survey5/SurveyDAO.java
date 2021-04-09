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
public interface SurveyDAO extends AutoCloseable{
    public void saveSurvey(Survey ss);
    public void deleteSurvey(Survey ss);
    public void updateSurvey(Survey ss);
    public List<Survey> getSurvey();
}
