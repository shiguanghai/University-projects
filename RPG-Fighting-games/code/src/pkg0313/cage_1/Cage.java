package pkg0313.cage_1;

public class Cage {
 
	public void take(Treasure t, double quantity) {//����quantity�����ߵ�����
		if(t.getNumber() >= quantity) {
			t.setNumber(t.getNumber()-quantity);
		}//����������õģ�Cage�Ͳ����ˡ�
		else{
			t.setNumber(0);
		}
	}	 
}