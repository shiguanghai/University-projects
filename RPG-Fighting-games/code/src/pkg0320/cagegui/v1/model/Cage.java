package pkg0320.cagegui.v1.model;

public class Cage {
 
	public void take(Treasure t, double quantity) {//����quantity�����ߵ�����
		if(t.getNumber() >= quantity) {
			t.setNumber(t.getNumber()-quantity);
		}else{//����������õģ�Cage���Ӻ����ж����ö��١�
			t.setNumber(0);
		}
		
	}	 
}