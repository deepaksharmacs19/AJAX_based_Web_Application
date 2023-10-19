package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;


public class DesignationTagHandler extends BodyTagSupport
{
public List<DesignationBean> list;
int index;

public DesignationTagHandler()
{
index=0;
reset();
}

private void reset()
{
index=0;
}

public int doStartTag()
{
List<DesignationDTO> designations=null;
try{
designations=new DesignationDAO().getAll();
}
catch(Exception exception)
{
return SKIP_BODY;
}
if(designations.size()==0) return SKIP_BODY;

list=new ArrayList<>();

for(DesignationDTO designation:designations)
{
DesignationBean bean=new DesignationBean();
bean.setCode(designation.getCode());
bean.setTitle(designation.getTitle());
list.add(bean);
}

DesignationBean bean=list.get(0);

pageContext.setAttribute("designationBean",bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("sno",index+1,PageContext.REQUEST_SCOPE);

index++;
return EVAL_BODY_INCLUDE;
}

public int doAfterBody()
{
if(index==list.size()) return SKIP_BODY;
DesignationBean bean=list.get(index);
pageContext.setAttribute("designationBean",bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("sno",index+1,PageContext.REQUEST_SCOPE);

index++;
return EVAL_BODY_AGAIN;
}

public int doEndTag()
{
reset();
return EVAL_PAGE;
}
}