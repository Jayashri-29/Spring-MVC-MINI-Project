package mypack.MVCMiniProject.Service;

import java.util.List;

import mypack.MVCMiniProject.Model.Department;

public interface DeptService 
{
 public boolean isAddDept(Department dept);
 public List<Department> getAllDept();
 public List<Department> getAllDeptDatabyId(int id);
 public boolean isUpdateDeptBYID(Department dept);
 public boolean delDeptById(int id);
}
