package demo2;
import java.awt.*;
import java.applet.*;
public class HelloWorld extends Applet //继承Applet类，这是Applet Java程序的特点
{
public void paint(Graphics g )
{
g.drawString("Hello World!",5,35);
}
}