
public class LIC14 {
    public static void main(String[] args) {
        double[] xs = {0, 0, 0, 0, 3, 0, 5};
		double[] ys = {1, 0, 1, 0, 3, 0, 1};
        double AREA1 = 3;
        double AREA2 = 6;
		System.out.println((LIC14.getCondition(xs, ys, AREA1, AREA2, 1, 1, xs.length)));
    }


	private static double dotProduct(double[] v1, double[] v2) {
		return v1[0]*v2[0] + v1[1]*v2[1];
	}

	private static double vecLen(double[] v) {
		return Math.sqrt(Math.pow(v[0], 2) + Math.pow(v[1], 2));
	}

	public static boolean getCondition(double[] xs, double[] ys, double AREA1, double AREA2, int e_pts, int f_pts, int numpoints) {
		if ( e_pts < 1 || f_pts < 1 || e_pts + f_pts > numpoints -3 || AREA1 <= 0 || AREA2 <= 0 || numpoints < 5) return false;
        boolean condition = false;
        boolean condArea1 = false;
        boolean condArea2 = false;
		double[] p1;
		double[] p2;
		double[] p3;
		double[] v1;
		double[] v2;
		double v1Len;
		double v2Len;
		double angle;
		double height;
		double area;
		for (int i = 0; i < numpoints - (e_pts + f_pts) - 2; i++) {
			p1 = new double[] {xs[i], ys[i]};
			p2 = new double[] {xs[i + 1 + e_pts], ys[i + 1 + e_pts]};
			p3 = new double[] {xs[i + 2 + f_pts + e_pts], ys[i + 2 + f_pts + e_pts]};
			v1 = new double[] {p1[0] - p2[0], p1[1] - p2[1]};
			v2 = new double[] {p1[0] - p3[0], p1[1] - p3[1]};
			v1Len = vecLen(v1);
            v2Len = vecLen(v2);
			if (v1Len == 0 || v2Len == 0) continue;
			angle = Math.acos(dotProduct(v1, v2)/(v1Len*v2Len));
			height = Math.sin(angle)*v2Len;
            area = v1Len*height/2;
            System.out.println("area: " + area);
			if (area > AREA1) {
				condArea1 = true;
            }
            if(area < AREA2){
                condArea2 = true;
            }
            if(condArea1 && condArea2){
                condition = true;
            }
		}
		return condition;
	}
}
