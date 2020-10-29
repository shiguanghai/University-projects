package pkg0401.n1;

public class TVFactory {
	private String brand;

	public static TV produceTV(String brand) throws Exception {
		if(brand.equals("Haier")){
			System.out.println("电视机工厂生产海尔电视机！");
			return new HaierTV();
		}else if(brand.equals("Hisense")){
			System.out.println("电视机工厂生产海信电视机！");
			return new HisenseTV();
		}else {
			throw new Exception("对不起，暂不能生产该品牌电视机！");
		}
	}
}
