package group18.parameters;

public class DOUBLECOMPARE {
	public static COMPTYPE doubleCompare(double A, double B){
		if (Math.abs(A-B) < 0.000001) return COMPTYPE.EQ;
		if (A < B) return COMPTYPE.LT;
		return COMPTYPE.GT;
	}
}
