package main;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * 
 * @author Gruppe 1
 * establishes connection to database
 * provides methods to get data
 *
 */

//will become a Singleton 
public class DBConnection {
	public static Connection conn;

	public DBConnection() throws Exception {
		
		if(DBConnection.conn == null) {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/myforestDB?"
                        + "user=User&password=myforest");
		}
//		conn = DriverManager.getConnection(
//				"jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7355900?user=sql7355900&password=kHaqmas865");
//		}
	}

	/**
	 * Get a list of all entries in the problem table
	 * 
	 * @return ArrayList of Problem
	 */
	public List<Problem> getAllProblems() {
		List<Problem> list = new ArrayList<Problem>();

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM problem");

			while (rs.next()) {
				Problem problem = convertProblemRow(rs);
				list.add(problem);
			}
			return list;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			new ErrorFrame("Es gab einen Fehler bei der Datenbankverbindung.","Prüfen Sie, ob Sie alle Schritte zur erfolgreichen Datenbankverbindung durchgeführt haben.");
			return null;
		}
	}

	/**
	 * get the entry in the problem table with the given id
	 * 
	 * @param id
	 * @return Problem
	 */
	public Problem getProblemByID(int id) {
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM problem WHERE id =" + id + "");
			Problem problem = null;
			if (rs.next()) {
				problem = convertProblemRow(rs);
			}
			return problem;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * get all entries in the area table
	 * 
	 * @return ArrayList of Areas
	 */
	public List<Area> getAllAreas() {
		List<Area> list = new ArrayList<Area>();

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM area");

			while (rs.next()) {
				Area area = convertAreaRow(rs);
				list.add(area);
			}
			return list;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), "There was an Error with the database Connection. Please check if the database is set up correctly (README)", "Dialog",
			        JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	/**
	 * get the Area from the area table with the given id
	 * 
	 * @param id
	 * @return Area
	 */
	public Area getAreaById(int id) {
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM area WHERE id =" + id + "");
			Area area = null;
			if (rs.next()) {
				area = convertAreaRow(rs);
			}
			return area;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * get all entries in the status table
	 * 
	 * @return ArrayList of Status
	 */
	public List<Status> getAllStatuses() {
		List<Status> list = new ArrayList<Status>();

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM status");

			while (rs.next()) {
				Status status = convertStatusRow(rs);
				list.add(status);
			}
			return list;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * get all entries in the Problem table that have the 'in Progress' Status
	 * 
	 * @return ArrayList of Problems
	 */
	public List<Problem> getProblemsInProgress(){
		List<Problem> list = new ArrayList<Problem>();

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM problem WHERE status_id= 1");

			while (rs.next()) {
				Problem problem = convertProblemRow(rs);
				list.add(problem);
			}
			return list;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param id of the status 
	 * @return the status with said id
	 */
	public Status getStatusById(int id) {
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM status WHERE id =" + id + "");
			Status status = null;
			if (rs.next()) {
				status = convertStatusRow(rs);
			}
			return status;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public Problem convertProblemRow(ResultSet rs) throws SQLException {
		//bug: id is always 0 although the id in the database is set correctly
		int id = rs.getInt("id");
		String description = rs.getString("description");
		int area_id = rs.getInt("area_id");
		int status_id = rs.getInt("status_id");
		String tree = rs.getString("tree");

		return new Problem(id, description, area_id, status_id, tree);
	}

	public Area convertAreaRow(ResultSet rs) throws SQLException {

		int id = rs.getInt("id");
		String description = rs.getString("description");

		return new Area(id, description);
	}

	public Status convertStatusRow(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String description = rs.getString("description");
		return new Status(id, description);
	}
	
	
	/**
	 * Inserts a new row into the Database Table Problem 
	 * @param problem Object of type Problem that should be inserted into Database Table
	 */
	public void insertProblem(Problem problem) {
		String stmt = "INSERT INTO problem(id, description,area_id, status_id, tree) VALUES(?,?,?,?,?)";

		try (PreparedStatement pstmt = conn.prepareStatement(stmt)) {
			pstmt.setInt(1, problem.getId());
			pstmt.setString(2, problem.getDescription());
			pstmt.setInt(3, problem.getArea_id());
			pstmt.setInt(4, problem.getStatus_id());
			pstmt.setString(5, problem.getTree());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * insert an area into the database table Area
	 * @param area
	 */
	public void insertArea(Area area){
		String stmt = "INSERT INTO area(id, description) VALUES(?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(stmt)) {
			pstmt.setInt(1, area.getId());
			pstmt.setString(2, area.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * insert a status into the database table Status
	 * @param status
	 */
	public void insertStatus(Status status){
		String stmt = "INSERT INTO status(id, description) VALUES(?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(stmt)) {
			pstmt.setInt(1, status.getId());
			pstmt.setString(2, status.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
	/**
	 * close the Database Connection 
	 */
	public static void close() {
		try {
			if(conn != null)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		DBConnection db;
//		try {
//			db = new DBConnection();
//			db.insertProblem(new Problem(10,"Baum auf Gehweg", 5, 3, "Birke") );
//			System.out.println(db.getProblemByID(10));
////			System.out.println(db.getAllProblems());
//			DBConnection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}