package mypack.MVCMiniProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypack.MVCMiniProject.Model.EmpModel;
import mypack.MVCMiniProject.Repository.EmpRepo;

@Service("empservice")
public class EmplServiceImpl implements EmpService {
	@Autowired
	EmpRepo emprepo;

	@Override
	public boolean isAddEmp(EmpModel emp) {
		return emprepo.isAddEmp(emp);
	}

	@Override
	public List<EmpModel> getAllEmp() {
		return emprepo.getAllEmp();
	}

	@Override
	public List<EmpModel> getDataById(int id) {
		return emprepo.getDataById(id);
	}

	@Override
	public boolean updateEmp(EmpModel emp) {
		return emprepo.isupdateemp(emp);
	}

	@Override
	public boolean isDelEmp(int id) {
		return emprepo.isDelEmp(id);
	}
}
