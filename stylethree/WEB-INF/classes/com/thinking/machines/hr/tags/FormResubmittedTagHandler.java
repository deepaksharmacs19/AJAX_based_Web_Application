package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
import javax.servlet.http.*;

public class FormResubmittedTagHandler extends TagSupport
{

public FormResubmittedTagHandler()
{
reset();
}

private void reset()
{
}

public int doStartTag()
{
HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
String formID=request.getParameter("form_id");
if(formID==null)
{
return super.EVAL_BODY_INCLUDE;
}
String formIDInSession=(String)pageContext.getAttribute(formID,PageContext.SESSION_SCOPE);
if(formIDInSession==null)return super.EVAL_BODY_INCLUDE;
pageContext.removeAttribute(formID,pageContext.SESSION_SCOPE);
if(formIDInSession.equals(formID))
{
return super.SKIP_BODY;
}
else return EVAL_BODY_INCLUDE;

}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}
}