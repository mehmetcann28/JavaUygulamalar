package GroupWork.Work1;

public class UrunDB {
	static Urun findById(int id) {
		for (Urun urun : Urun.urunArrayList) {
			if (id == urun.getUrunId()) {
				return urun;
			}
		}
		return null;
	}
}