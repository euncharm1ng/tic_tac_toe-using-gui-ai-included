package swingSimpleEX;
import java.util.Random;
public class ai {
	public int isItMe(int usrNum, int []index, int myNum) {
		if(usrNum!=myNum)
			return -1;
		else
			return tryToWin(index, myNum);
	}
	private int tryToWin(int []index, int myNum) {
		int []indexValue=new int[9];

		for(int i=0; i<3; i++) 
			route123(index, myNum, indexValue, i);
		for(int i=0; i<8; i+=3) 
			route456(index, myNum, indexValue, i);
		route7(index, myNum, indexValue);
		route8(index, myNum, indexValue);
		
		return checkRValue(indexValue, index);
	}
	private int checkRValue(int []indexValue, int []index) {
		int max=-1, maxValue=-1, randcount=0;
		int []randArr=new int[4];
		for(int i=0; i<9; i++) {
			if(index[i]!=0) continue;
			if (indexValue[i]>maxValue) {
				max=i;
				maxValue=indexValue[i];
			}
		}
		for(int i=0; i<9; i++) {
			if(index[i]!=0) continue;
			if(indexValue[i]==maxValue) {
				randArr[randcount]=i;
				randcount++;
			}
		}
		max=randomness(randArr, randcount);
		return max;
	}
	private int randomness(int []randArr, int count) {
		Random rand = new Random();
		int n = rand.nextInt(count);
		return randArr[n];
	}
	private int checkRoute(int index[], int num1, int num2, int num3, int myNum) {
		int me=0, opp=0;
		if(index[num1]==myNum) me++;
		else if(index[num1]!=0) opp++;
		if(index[num2]==myNum) me++;
		else if(index[num2]!=0) opp++;
		if(index[num3]==myNum) me++;
		else if(index[num3]!=0) opp++;
		
		if(me==opp) return 1-me;
		else if(me==1||opp==1) return 2;
		else if (me==2)return 100;
		else return 50;
	}
	private void route123(int []index, int myNum, int []indexValue, int indNum) {
		if(index[indNum]!=0&&index[indNum+3]!=0&&index[indNum+6]!=0) return;
		int increase = checkRoute(index, indNum, indNum+3, indNum+6, myNum);
		indexValue[indNum]+=increase;
		indexValue[indNum+3]+=increase;
		indexValue[indNum+6]+=increase;
	}
	private void route456(int []index, int myNum, int []indexValue, int indNum) {
		if(index[indNum]!=0&&index[indNum+1]!=0&&index[indNum+2]!=0) return;
		int increase = checkRoute(index, indNum, indNum+1, indNum+2, myNum);
		indexValue[indNum]+=increase;
		indexValue[indNum+1]+=increase;
		indexValue[indNum+2]+=increase;
	}
	private void route7(int []index, int myNum, int []indexValue) {
		if(index[2]!=0&&index[4]!=0&&index[6]!=0) return;
		int increase = checkRoute(index, 2, 4, 6, myNum);
		indexValue[2]+=increase;
		indexValue[4]+=increase;
		indexValue[6]+=increase;
	}
	private void route8(int []index, int myNum, int []indexValue) {
		if(index[0]!=0&&index[4]!=0&&index[8]!=0) return;
		int increase = checkRoute(index, 0, 4, 8, myNum);
		indexValue[0]+=increase;
		indexValue[4]+=increase;
		indexValue[8]+=increase;
	}	
}
