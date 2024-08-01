package uygulamalar.utilities.enums;

public enum EKategori {
	GIYIM(8),
	ELEKTRONIK(4),
	BAKIM(5),
	YIYECEK(10),
	AKSESUAR(4);
	
	private Integer sinir;
	
	EKategori(Integer sinir) {
		this.sinir = sinir;
	}
	
	public Integer getSinir() {
		return sinir;
	}
	
	public void setSinir(Integer sinir) {
		this.sinir = sinir;
	}
}