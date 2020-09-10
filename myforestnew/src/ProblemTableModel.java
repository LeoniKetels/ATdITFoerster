import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Gruppe 1
 * Table Model to display problems 
 *
 */

public class ProblemTableModel extends AbstractTableModel {
	List<Problem> problems;
	
	 private static final String[] columns = new String[]{"ID", "Beschreibung", "Bereich", "Status", "Baum"};

	
	public ProblemTableModel(List<Problem> problems) {
		this.problems = problems;
	}
	 @Override
	    public String getColumnName(int columnIndex){
	         return columns[columnIndex];
	    }


	@Override
	public int getRowCount() {
		return problems.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
		Problem problem = getProblem(rowIndex);
		DBConnection dbConnection = new DBConnection();
        if(problem != null) {
            switch (columnIndex) {
                case 0:
                    return problem.getId();
                case 1:
                    return problem.getDescription();
                case 2:
                	int area = problem.getArea_id();
                    return dbConnection.getAreaById(area).getDescription();
                case 3:
                	int status = problem.getStatus_id();
                    return dbConnection.getStatusById(status).getDescription();
                case 4: 
                	return problem.getTree();
            }

            }
        dbConnection.close();
        }
		catch( Exception e ) {
			e.printStackTrace();

        }
        return "";	
        
	}
	
	 public Problem getProblem(int rowIndex) {
	        if (getRowCount() > rowIndex && rowIndex >= 0) {
	            return problems.get(rowIndex);
	        }
	        return null;
	    }

}
