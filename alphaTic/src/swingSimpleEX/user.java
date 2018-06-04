package swingSimpleEX;

public class user {
   int index[]= {0,0,0,0,0,0,0,0,0};
   
   public int resetindex(int index[]){
	   for(int a=0; a<9; a++) {
		   index[a] = 0;
	   }
	   return 0;
   }
   public boolean userInput(int usrNum, int buttonNum) {
	  if(index[buttonNum]!=0) {
         System.out.println("taken already, retry");
         return false;
      }
      index[buttonNum]=usrNum;
 
      if(checkWinCondition()!=0)
    	  if(checkWinCondition()==3)
    		  System.out.println("tie");
    	  else
    		  System.out.println("player"+usrNum+"wins");
      return true;
   }
   
   public int checkWinCondition() {
      if(diff3()!=0) {
         System.out.println("diff3");
         return diff3();
      }
      else if(diff1()!=0) {
         System.out.println("diff1");
         return diff1();
      }
      else if(diffOther()!=0) {
         System.out.println("diffother");
         return diffOther();
      }
      for(int i=0; i<9; i++) {
    	  if(index[i]==0) {
    		  return 0;
    	  }
      }
      return 3;
   }
   
   private int diff3() {
      for(int i=0; i<3; i++) {
         if(index[i]!=0&&index[i]==index[i+3]&&index[i+3]==index[i+6])
            return index[i];
      }
      return 0;
   }
   private int diff1() {
      for(int i=0; i<8; i+=3) {
  	   	  if(index[i]!=0&&index[i]==index[i+1]&&index[i+1]==index[i+2])
  	   		  return index[i];
      }
      return 0;
   }
   private int diffOther() {
      if(index[0]==index[4]&&index[4]==index[8])
         return index[0];
      if(index[2]==index[4]&&index[4]==index[6])
         return index[2];
      return 0;
   }
   
}
