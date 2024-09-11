package mypack.MVCMiniProject.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mypack.MVCMiniProject.Model.EmpModel;

@Repository("emprepo")
public class EmpRepoImpl implements EmpRepo
{
    @Autowired
    JdbcTemplate template;
    List<EmpModel> list;
	@Override
	public boolean isAddEmp(EmpModel emp) {
		int value=template.update("insert into employee values('0',?,?,?,?)",  new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, emp.getEname());
				ps.setString(2, emp.getEmail());
				ps.setString(3, emp.getContact());
				ps.setInt(4, emp.getId());
			}			
		});
		return value>0?true:false;
	}
	@Override
	public List<EmpModel> getAllEmp() 
	{
		list=template.query("select *from employee e inner join dept d on e.id=d.id", new RowMapper<EmpModel>() {

			@Override
			public EmpModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpModel e=new EmpModel();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setContact(rs.getString(4));
				e.setId(rs.getInt(5));
				e.setName(rs.getString(7));
				return e;
			}
			
		});
		return list.size()>0?list:null;
	}
	@Override
	public List<EmpModel> getDataById(int id) {
		RowMapper<EmpModel> r=new RowMapper<EmpModel>()
				{
					@Override
					public EmpModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmpModel e=new EmpModel();
						e.setEid(rs.getInt(1));
						e.setEname(rs.getString(2));
						e.setEmail(rs.getString(3));
						e.setContact(rs.getString(4));						
						return e;
					}			
				};
		PreparedStatementSetter p=new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
				
			}			
		};
		list=template.query("select * from employee where eid=?",p,r);
		return list.size()>0?list:null;
	}
	@Override
	public boolean isupdateemp(EmpModel emp)
	{
		int value=template.update("update employee set ename=?,email=?,contact=?,id=? where eid=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, emp.getEname());
				ps.setString(2, emp.getEmail());
				ps.setString(3, emp.getContact());
				ps.setInt(4, emp.getId());
				ps.setInt(5, emp.getEid());
			}
		});
		return value>0?true:false;
	}
	@Override
	public boolean isDelEmp(int id)
	{
		int value=template.update("delete from employee where eid=?",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,id);
				
			}
			
		});
		return value>0?true:false;
	}

}
