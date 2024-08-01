package uygulamalar;

import java.text.DecimalFormat;

public class Sabit {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public static double formatAndParseDouble(double value) {
		// Virgülü nokta ile değiştir ve parse et
		return Double.parseDouble(df.format(value).replace(",", "."));
	}
}