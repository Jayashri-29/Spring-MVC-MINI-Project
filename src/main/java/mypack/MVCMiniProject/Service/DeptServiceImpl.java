package mypack.MVCMiniProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mypack.MVCMiniProject.Model.Department;
import mypack.MVCMiniProject.Repository.DeptRepo;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptRepo deptRepo;

	@Override
	public boolean isAddDept(Department dept) {

		return deptRepo.isAddDept(dept);
	}

	@Override
	public List<Department> getAllDept() {
		return deptRepo.getAllDepartment();
	}

	@Override
	public List<Department> getAllDeptDatabyId(int id) {
		return deptRepo.getDeptDataById(id);
	}

	@Override
	public boolean isUpdateDeptBYID(Department dept) {
		return deptRepo.isUpdateDeptBYID(dept);
	}

	@Override
	public boolean delDeptById(int id) {
		return deptRepo.deldeptById(id);
	}

}
