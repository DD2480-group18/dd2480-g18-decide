package group18.parameters;

public class PARAMETERS_T {
	public double LENGTH1;
	public double LENGTH2;
	public double RADIUS1;
	public double RADIUS2;
	public double AREA1;
	public double AREA2;
	public double EPSILON;
	public double DIST;

	public int Q_PTS;
	public int QUADS;
	public int N_PTS;
	public int K_PTS;
	public int A_PTS;
	public int B_PTS;
	public int C_PTS;
	public int D_PTS;
	public int E_PTS;
	public int F_PTS;
	public int G_PTS;

	public void init(double LENGTH1, double LENGTH2, double RADIUS1, double RADIUS2, double AREA1, double AREA2,
						double EPSILON, double DIST, int Q_PTS, int QUADS, int N_PTS, int K_PTS, int A_PTS, int B_PTS,
						int C_PTS, int D_PTS, int E_PTS, int F_PTS, int G_PTS){
		this.LENGTH1 = LENGTH1; // 0, 7, 12
		this.LENGTH2 = LENGTH2; // 12
		this.RADIUS1 = RADIUS1; // 1, 8, 13
		this.RADIUS2 = RADIUS2; // 13
		this.AREA1 = AREA1;		// 3, 10, 14
		this.AREA2 = AREA2;		// 14
		this.EPSILON = EPSILON;	// 2, 9
		this.DIST = DIST;		// 6
		this.Q_PTS = Q_PTS;		// 4
		this.QUADS = QUADS;		// 4
		this.N_PTS = N_PTS;		// 6
		this.K_PTS = K_PTS;		// 7, 12
		this.A_PTS = A_PTS;		// 8, 13
		this.B_PTS = B_PTS;		// 8, 13
		this.C_PTS = C_PTS;		// 9
		this.D_PTS = D_PTS;		// 9
		this.E_PTS = E_PTS;		// 10, 14
		this.F_PTS = F_PTS;		// 10, 14
		this.G_PTS = G_PTS;		// 11
	}

}
