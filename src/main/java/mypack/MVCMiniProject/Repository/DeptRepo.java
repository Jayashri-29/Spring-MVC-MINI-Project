package mypack.MVCMiniProject.Repository;

import java.util.List;

import mypack.MVCMiniProject.Model.Department;

public interface DeptRepo 
{
 public boolean isAddDept(Department dept);
 public List<Department> getAllDepartment();
 public List<Department> getDeptDataById(int id);
 public boolean isUpdateDeptBYID(Department dept);
 public boolean deldeptById(int id);
}
