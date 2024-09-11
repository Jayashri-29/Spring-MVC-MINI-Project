package mypack.MVCMiniProject.Service;

import mypack.MVCMiniProject.Model.EmpModel;
import java.util.*;
public interface EmpService
{
 public boolean isAddEmp(EmpModel emp);
 public List<EmpModel> getAllEmp();
 public List<EmpModel> getDataById(int id);
 public boolean updateEmp(EmpModel emp);
 public boolean isDelEmp(int id);
}
