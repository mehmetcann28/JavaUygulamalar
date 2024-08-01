package GroupWork.Work1;

public class Kullanici {
	private static Integer idCount = 0;
	private Integer kullaniciId;
	private String kullaniciAdi;
	private String sifre;
	private String email;
	private Sepet sepet;
	
	public Kullanici(String kullaniciAdi, String sifre, String email) {
		this.kullaniciId = ++idCount;
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;
		this.email = email;
		this.sepet = new Sepet();
	}
	
	public Integer getKullaniciId() {
		return kullaniciId;
	}
	
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	
	public String getSifre() {
		return sifre;
	}
	
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Sepet getSepet() {
		return sepet;
	}
	
	public void setSepet(Sepet sepet) {
		this.sepet = sepet;
	}
	
	@Override
	public String toString() {
		return "Kullanici{" +
				"kullaniciId=" + kullaniciId +
				", kullaniciAdi='" + kullaniciAdi + '\'' +
				", sifre='" + sifre + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}