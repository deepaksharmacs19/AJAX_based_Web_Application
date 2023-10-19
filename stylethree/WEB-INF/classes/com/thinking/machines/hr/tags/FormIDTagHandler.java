package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class FormIDTagHandler extends TagSupport
{

public FormIDTagHandler()
{
reset();
}

private void reset()
{
}

public int doStartTag()
{
String formID=UUID.randomUUID().toString();
pageContext.setAttribute(formID,formID,PageContext.SESSION_SCOPE);
JspWriter jw=pageContext.getOut();
try{
jw.print("<input type='hidden' name='form_id' id='form_id' value='"+formID+"'>");

}catch(Exception exception)
{

}
return SKIP_BODY;
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}