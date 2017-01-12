package hangman;

import java.util.Arrays;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		String[] word={"bicycle","fuck","apple","football"};
		int count=0;
		int missCount=0;
		
		String randomWord=word[(int)(Math.random()*word.length)];
		
		//System.out.print("Enter a letter in word");
		/*for(int i=0;i<randomWord.length();i++){
			System.out.print("*");
		}*/
		String chArr=printOut(randomWord);
		//System.out.print(chArr);
		
		while(count<randomWord.length()-1){
		 System.out.print("Enter a letter in word "+chArr);
		 char ch=input.nextLine().charAt(0);
		 if(isInTheGuessWord(chArr, ch)) System.out.println(ch+" is already in the guessed word");
			if(isNotIntheWord(randomWord, ch)) {
				System.out.println(ch+" is not in the word");
				missCount++;
			}
			if(!isInTheGuessWord(chArr, ch) && !isNotIntheWord(randomWord, ch)){
				count++;
			}
		 chArr=checkWord(chArr, randomWord, ch);
		
		 
		
		// System.out.print(checkWord(chArr, randomWord, ch, count));
		
		/*for(int i=0;i<randomWord.length();i++){
			if(randomWord.charAt(i)==ch) {
				
				System.out.print(randomWord.charAt(i));
				count++;
			}
			else System.out.print("*");
			
		}*/
		
		}
		System.out.println("You miss "+missCount);
		System.out.println("The word is "+randomWord);
	}
	
	private static String printOut(String w) {
		char[] cha=new char[w.length()];
		for(int i=0;i<cha.length;i++){
			cha[i]='*';
		}
		
		return new String(cha);
		
	}
	
	private static String checkWord(String chArray,String w, char c){
		char[] ch=chArray.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(w.charAt(i)==c){
		      ch[i]=c;
				//count++;
			}
		}
		return new String(ch);
		
	}
	private static boolean isInTheGuessWord(String c, char ch) {
		//boolean isIn=false;
		 for(int i=0;i<c.length();i++){
			 if(c.charAt(i)==ch) return true;
			 }
			
			 return false;
		 }
	private static boolean isNotIntheWord(String w,char ch) {
		for(int i=0;i<w.length();i++){
			if(w.charAt(i)==ch) return false;
				 
		
	}
		return true;
		
		
	}


}
