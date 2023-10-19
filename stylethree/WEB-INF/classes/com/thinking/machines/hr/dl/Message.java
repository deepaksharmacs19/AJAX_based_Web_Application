package com.thinking.machines.hr.dl;

public class Message implements java.io.Serializable
{
private String heading;
private String message;
public boolean generateButtons;
public boolean generateTwoButtons;

private String buttonOneText;
private String buttonTwoText;
private String buttonOneAction;
private String buttonTwoAction;

public Message()
{
this.message="";
this.heading="";
this.generateButtons=false;
this.generateTwoButtons=false;
}

public void setMessage(String message)
{
this.message=message;
}

public void setGenerateButtons(boolean generateButtons)
{
this.generateButtons=generateButtons;
}

public void setGenerateTwoButtons(boolean generateTwoButtons)
{
this.generateTwoButtons=generateTwoButtons;
}

public boolean getGenerateButtons()
{
return this.generateButtons;
}

public boolean getGenerateTwoButtons()
{
return this.generateTwoButtons; 
}

public void setHeading(String heading)
{
this.heading=heading;
}
public String getHeading()
{
return this.heading;
}

public String getMessage()
{
return this.message;
}

public void setButtonOneText(String buttonOneText)
{
this.buttonOneText=buttonOneText;
}

public String getButtonOneText()
{
return this.buttonOneText;
}

public void setButtonOneAction(String buttonOneAction)
{
this.buttonOneAction=buttonOneAction;
}

public String getButtonOneAction()
{
return this.buttonOneAction;
}

public void setButtonTwoText(String buttonTwoText)
{
this.buttonTwoText=buttonTwoText;
}

public String getButtonTwoText()
{
return this.buttonTwoText;
}

public void setButtonTwoAction(String buttonTwoAction)
{
this.buttonTwoAction=buttonTwoAction;
}

public String getButtonTwoAction()
{
return this.buttonTwoAction;
}

}