package GroupWork.Work1.utilities.enums;

public enum EKategori {
	GIYIM(8),
	ELEKTRONIK(5),
	BAKIM(15),
	YIYECEK(10),
	AKSESUAR(4);
	
	private Integer sinir;
	
	EKategori(Integer sinir) {
		this.sinir = sinir;
	}
	
	public Integer getSinir() {
		return sinir;
	}
}