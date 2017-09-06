package demo2;

import java.awt.*;
import java.applet.*;

public class Test extends Applet // 继承Appelet类，这是Applet Java程序的特点
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1612866032443092499L;

	public void paint(Graphics g) {
		people zhang;
		zhang = new people();
		zhang.setname("Robot");
		zhang.setage(12);
		g.drawString(zhang.talk(), 5, 35);
	}
}

class people {
	private String name;
	private int age;

	String talk() {
		return "我是" + name + ";今年" + age + "岁";
	}

	public void setname(String str) {
		name = str;
	}

	public void setage(int a) {
		if (a > 0)
			age = a;
		else
			age = -a;
	}

	public String getname() {
		return name;
	}

	public int getage() {
		return age;
	}
}