package main.DBSelects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.DBConnection;
import main.Problem;

public class GetProblems extends DBConnection {
	
	public GetProblems() throws Exception {
		super();
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
			return null;
		}
	};
	
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

}
