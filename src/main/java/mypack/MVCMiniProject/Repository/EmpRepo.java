package mypack.MVCMiniProject.Repository;

import java.util.List;

import mypack.MVCMiniProject.Model.EmpModel;

public interface EmpRepo {
public boolean isAddEmp(EmpModel emp);
public List<EmpModel> getAllEmp();
public List<EmpModel> getDataById(int id);
public boolean isupdateemp(EmpModel emp);
public boolean isDelEmp(int id);
}
