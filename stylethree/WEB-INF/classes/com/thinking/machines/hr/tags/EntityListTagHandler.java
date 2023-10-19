package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.lang.reflect.*;

public class EntityListTagHandler extends BodyTagSupport
{
String populatorClass;
String populatorMethod;
String name;

public List<?> list;
int index;

public EntityListTagHandler()
{
reset();
}

private void reset()
{
index=0;
populatorClass="";
populatorMethod="";
name="";
}

public void setPopulatorMethod(String populatorMethod)
{
this.populatorMethod=populatorMethod;
}

public void setPopulatorClass(String populatorClass)
{
this.populatorClass=populatorClass;
}

public void setName(String name)
{
this.name=name;
}

public String getPopulatorMethod()
{
return this.populatorMethod;
}

public String getPopulatorClass()
{
return this.populatorClass;
}

public String getName()
{
return this.name;
}


public int doStartTag()
{

try{
Class c=Class.forName(populatorClass);

Method m=c.getMethod(populatorMethod);

Object obj=c.newInstance();
list=(List)m.invoke(obj);

}catch(Exception exception)
{
return SKIP_BODY;
}

if(list.size()==0) return SKIP_BODY;

Object bean=list.get(0);

pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("sno",index+1,PageContext.REQUEST_SCOPE);

index++;
return EVAL_BODY_INCLUDE;
}

public int doAfterBody()
{
if(index>=list.size()) return SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(name,bean,PageContext.REQUEST_SCOPE);
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