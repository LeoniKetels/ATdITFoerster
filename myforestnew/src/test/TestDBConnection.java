package test;
import org.junit.Assert;
import org.junit.Test;

 


import java.util.ArrayList;
import java.util.List;

 

import main.Area;
import main.Status;
import main.DBConnection;
import main.Problem;

 

/**
 * @author Gruppe 1
 * Method for Unit Tests of class DBConnection
 */
public class TestDBConnection {
    /**
     *Testing get Problem by Id from Database
     * @throws Exception 
     */
    @Test
    public void testGetProblem() throws Exception {
        DBConnection connection = new DBConnection();
        Problem problemTest = new Problem(1, "Der Baum ist kaputt",1,1, "Buche");
        Assert.assertEquals(problemTest.toString(),connection.getProblemByID(1).toString());
    }
    
    //insertProblem Methode testen mit contains Methode in der Liste funktioniert nicht
    /**
     *Testing get Problem by Id from Database
     * @throws Exception 
     */
    @Test
    public void testInsertProblem() throws Exception {
        Problem problemTest = new Problem(100, "Testproblem",1,1, "Eiche");
        DBConnection connection = new DBConnection();
        connection.insertProblem(problemTest);
        List<Problem> problemList = new ArrayList<Problem>();
        problemList = connection.getAllProblems();
        Assert.assertTrue((problemList.contains(problemTest)));
    }
    
        /**
         *Testing get Problem by Id from Database
         * @throws Exception 
         */
        @Test
        public void testGetAllAreas() throws Exception {
            Area testArea = new Area(1, "49.349187, 7.923600");
            DBConnection connection = new DBConnection();
            List<Area> areaList = connection.getAllAreas();
            Assert.assertTrue((areaList.contains(testArea)));
        }
    
    
    /**
     *Testing get Area by Id from Database
     * @throws Exception 
     */
    @Test
    public void testGetArea() throws Exception {
        DBConnection connection = new DBConnection();
        Area testArea = new Area(1, "49.349187, 7.923600");
        Assert.assertEquals(testArea.toString(),connection.getAreaById(1).toString());
    }
    
    /**
     *Testing get Status by Id from Database
     * @throws Exception 
     */
    @Test
    public void testGetStatus() throws Exception {
        DBConnection connection = new DBConnection();
        Status testStatus = new Status(1, "Offen");
        Assert.assertEquals(testStatus.toString(),connection.getStatusById(1).toString());
    } 
    
    /**
     *Testing change Status 
     * @throws Exception 
     */
    @Test
    public void testChangeStatus() throws Exception {
        DBConnection connection = new DBConnection();
        connection.changeStatus(1, 2);
        Problem problemTest = new Problem(1, "Der Baum ist kaputt",1,2, "Buche");
        Assert.assertEquals(problemTest.toString(),connection.getProblemByID(1).toString());
    }    
}