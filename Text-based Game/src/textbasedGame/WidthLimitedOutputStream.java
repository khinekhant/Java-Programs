package textbasedGame;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class WidthLimitedOutputStream {
private PrintStream out;
private int width;

public WidthLimitedOutputStream(OutputStream out,int width){
	this.out=new PrintStream(out);
	this.width=width;
}

public void print(String str){
	int currentWidth=0;
	StringTokenizer tokenizer=new StringTokenizer(str);

	//while words are still left
	while (tokenizer.hasMoreElements()) {
		String token = (String) tokenizer.nextElement();
		
		//if word exceed width limit
		if(currentWidth+token.length()>=width){
			out.println();
			currentWidth=0;
		}
		
		out.print(token+" ");
		
		currentWidth+=token.length();
		
	}
	out.flush();
}


public void println(String str){
	print(str);
	out.println();
}

//print a blank line
public void println(){
	out.println();
}
}
