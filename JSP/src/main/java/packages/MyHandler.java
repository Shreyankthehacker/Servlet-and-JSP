package packages;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class MyHandler extends TagSupport{

private int num1 , num2 ;

public int getNum1() {
	return num1;
}

public void setNum1(String  num1) {
	this.num1 = Integer.parseInt(num1);
}

public int getNum2() {
	return num2;
}

public void setNum2(String num2) {
	this.num2 = Integer.parseInt(num2);
}

	public int doStartTag() {
		int res = num1+num2;
		try {
			JspWriter out = pageContext.getOut();
			out.println("addition is "+res);
		}
		catch(Exception e) {}
		return Tag.EVAL_BODY_INCLUDE;
	}

}
