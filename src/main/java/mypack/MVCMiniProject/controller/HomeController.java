package mypack.MVCMiniProject.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import mypack.MVCMiniProject.Model.*;
import mypack.MVCMiniProject.Service.*;

@Controller
public class HomeController {

	@Autowired
	DeptService deptService;
    @Autowired
    EmpService empservice;
	@RequestMapping(value = "/")
	public String HomePage() {
		return "index";
	}
	@RequestMapping(value="/register")
    public String register()
    {
    	return "AddEmp";
    }
	@RequestMapping(value = "/saveemp", method = RequestMethod.GET)
	public String AddEmpPage(Department dept, Map<String, String> m) {
		boolean b = deptService.isAddDept(dept);
		if (b) {
			m.put("msg", "Department Added Successfully");
		} else {
			m.put("msg", "Some problem Occured");
		}

		return "AddEmp";
	}
	@RequestMapping(value="/viewdept")
	public String viewDepartmet(Map<String,List> map)
	{
		List<Department> list=deptService.getAllDept();
		map.put("deptList", list);
		return "ViewDept";
	}
    @RequestMapping(value="/upddept")
	public String updDept(@RequestParam("deptid") Integer deptId,Map<String,List> map)
	{
    	List<Department> list=deptService.getAllDeptDatabyId(deptId);
    	map.put("dept", list);
		return "EditDept";
	}
    @RequestMapping(value="/editdept",method=RequestMethod.GET)
    public String saveEditDept(Department dept,Map<String,String> m,Map<String,List> map)
    {
    	boolean b=deptService.isUpdateDeptBYID(dept);
    	if(b) {
    		List<Department> list=deptService.getAllDept();
    		map.put("deptList", list);
    		return "ViewDept";
    	}
    	else
    	{
    		m.put("msg","Problem occured");
    		return "EditDept";
    	}
    }
    @RequestMapping(value="deldept")
    public String delDeptById(@RequestParam("deptid") Integer DeptId,Map<String,String> m,Map<String,List> map)
    {
    	boolean b=deptService.delDeptById(DeptId);
    	if(b)
    	{
    		List<Department> list=deptService.getAllDept();
    		map.put("deptList", list);
    		return "ViewDept";
    	}
    	else
    	{
    		m.put("msg", "Some Problem is there");
    		return "ViewDept";
    	}
    }
    @RequestMapping(value="/regemp")
    public String addEmp(Map<String,List> map)
    {

		List<Department> list=deptService.getAllDept();
		map.put("deptList", list);
		return "AddEmployee";   
    }
    @RequestMapping(value="registeremp",method=RequestMethod.GET)
    public String registeremp(EmpModel emp,Map<String,String> m)

    {
    	boolean b=empservice.isAddEmp(emp);
    	if(b)
    	{
			m.put("msg", "Employee Added Successfully");
		} else {
			m.put("msg", "Some problem Occured");
		}	
    	return "AddEmployee";
    }
    @RequestMapping(value="/viewemp")
    public String viewEmpl(Map<String,List> m)
    {
    	List<EmpModel> list=empservice.getAllEmp();
    	m.put("emplist", list);  	
    	return "ViewEmp";
    }
    @RequestMapping(value="/updemp")
    public String updemp(@RequestParam("eid") Integer empId,Map<String,List> m)
    {
    	List<EmpModel> list=empservice.getDataById(empId);
    	m.put("emplist", list);
    	List<Department> list1=deptService.getAllDept();
		m.put("deptList", list1);
    	return "EditEmp";
    }
    @RequestMapping(value="/editemp",method=RequestMethod.GET)
    public String saveEditEmp(EmpModel emp,Map<String,String> m,Map<String,List> map)
    {
        boolean b=empservice.updateEmp(emp);
        if(b) {
    		List<EmpModel> list=empservice.getAllEmp();
    		map.put("emplist", list);
    		return "ViewEmp";
    	}
    	else
    	{
    		m.put("msg","Problem occured");
    		return "EditEmp";
    	}
    }
    @RequestMapping(value="/delemp")
    public String delEmp(@RequestParam("eid") Integer empId,Map<String,List> m,Map<String,String> map)
    {
    	boolean b=empservice.isDelEmp(empId);
    	if(b)
    	{
        	List<EmpModel> list=empservice.getAllEmp();
        	m.put("emplist", list);  	
        	return "ViewEmp";
    	}
    	else
    	{
    		map.put("msg", "Some problem occured");
    		return "ViewEmp";
    	}
    	
    }
    @RequestMapping(value="/empdeptwise")
    public String displayempdeptwise(Map<String,List> m)
    {
    	List<Department> list=deptService.getAllDept();
    	m.put("deptlist", list);
    	return "ViewEmpDeptWise";
    }
    @RequestMapping(value="/GetEmpbyDeptId")
    public String returnData(@RequestParam("id") Integer deptId)
    {
      return "";
    }
    
}
