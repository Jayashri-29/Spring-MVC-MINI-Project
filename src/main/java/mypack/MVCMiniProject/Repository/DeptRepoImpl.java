package mypack.MVCMiniProject.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mypack.MVCMiniProject.Model.Department;

@Repository("deptRepo")
public class DeptRepoImpl implements DeptRepo {

	@Autowired
	JdbcTemplate template;
    List<Department> list;
	@Override
	public boolean isAddDept(Department dept) {
		int value = template.update("insert into dept values('0',?)", new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dept.getName());

			}
		});
		return value > 0 ? true : false;
	}

	@Override
	public List<Department> getAllDepartment() 
	{
		list=template.query("select *from dept", new RowMapper<Department>()
				{

					@Override
					public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
						Department d=new Department();
						d.setId(rs.getInt(1));
						d.setName(rs.getString(2));
						return d;
					}
			
				});
		
		return list.size()>0?list:null;
	}

	@Override
	public List<Department> getDeptDataById(int id) {
		RowMapper<Department> rm=new RowMapper<Department>() {

			@Override
			public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
				Department d=new Department();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				return d;
			}	
		};
		PreparedStatementSetter ps=new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
				
			}
		};
		list=template.query("select *from dept where id=?",ps,rm);
		return list.size()>0?list:null;
	}

	@Override
	public boolean isUpdateDeptBYID(Department dept) {
		int value=template.update("update dept set name=? where id=?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dept.getName());
				ps.setInt(2,dept.getId());				
			}			
		});
		return value>0?true:false;
	}

	@Override
	public boolean deldeptById(int id) {
		int value=template.update("delete from dept where id=?",new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
				
			}
			
		});
		return value>0?true:false;
	}

}
