package pkg0401.n1;

public class TVFactory {
	private String brand;

	public static TV produceTV(String brand) throws Exception {
		if(brand.equals("Haier")){
			System.out.println("���ӻ����������������ӻ���");
			return new HaierTV();
		}else if(brand.equals("Hisense")){
			System.out.println("���ӻ������������ŵ��ӻ���");
			return new HisenseTV();
		}else {
			throw new Exception("�Բ����ݲ���������Ʒ�Ƶ��ӻ���");
		}
	}
}
