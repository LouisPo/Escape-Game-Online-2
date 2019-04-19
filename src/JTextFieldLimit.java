import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
  private int limit;

 public JTextFieldLimit(int limitation){
	 this.limit=limitation;
 }
 public void insertString(int offset, String str, javax.swing.text.AttributeSet set)throws BadLocationException{
if(str==null){
	return;
}else if((getLength()+str.length())<= limit){
	str=str.toUpperCase();
	super.insertString(offset, str, set);
}
 }
 
 
 
 
}