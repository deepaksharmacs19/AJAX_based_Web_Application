package com.thinking.machines.hr.bl;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
public class DesignationBL
{
public List<DesignationBean> getAll() {
List<DesignationBean> list=new ArrayList<>();
try{
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> listdl=designationDAO.getAll();
DesignationBean designationBean;
for(DesignationDTO dto:listdl)
{
designationBean=new DesignationBean();
designationBean.setCode(dto.getCode());
designationBean.setTitle(dto.getTitle());
list.add(designationBean);
}
}
catch(Exception exception)
{
System.out.println(exception);
}
return list;
}

}