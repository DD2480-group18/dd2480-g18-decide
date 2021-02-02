package group18.LIC;

public class LIC4 {
	public static boolean lic4(int q_pts, int quads, double[] X, double[] Y){
		for (int i = 0; i <= X.length-q_pts; ++i){
			boolean[] taken = {false, false, false, false};
			for (int j = 0; j < q_pts; j++) {
				if (X[i+j] >= 0){
					if (Y[i+j] >= 0){
						taken[0] = true;
					}
					else if (X[i+j] == 0){ //quadrant priority
						taken[2] = true;
					}
					else{
						taken[3] = true;
					}
				}
				else {
					if (Y[i+j] >= 0){
						taken[1] = true;
					}
					else {
						taken[2] = true;
					}
				}
			}
			int c = 0;
			for (int j = 0; j < 4; j++) {
				if (taken[j]){
					c++;
				}
			}
			if (c > quads) return true;
		}
		return false;
	}
}
