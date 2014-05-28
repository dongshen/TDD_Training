package conway_game;

public class conway_game {

	private int[][] area;
	private int[][] next_area;

	public int[][] GenerateArea(int x, int y) {

		area = new int[x][y];
		// next_area = Arrays.copyOf(area, area.length*area[0].length);

		return area;

	}

	public void setValue(int[][] initialValue) {
		area = initialValue;
		next_area = initialValue;
	}

	public int getCell(int x, int y) {
		if (x < 0 || x >= area.length) {
			return 0;
		}

		if (y < 0 || y >= area[0].length) {
			return 0;
		}

		return area[x][y];
	}
	
	public String PrintArea() {
		String result = "";
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				result = result + ("(" + i + "," + j + ")=" + getCell(i, j));
			}
			result = result + "\n";
		}
		return result;
	}

	public int checkNeighborStatus(int x, int y) {
		int sum = 0;

		// top line
		sum = sum + getCell(x - 1, y - 1);
		sum = sum + getCell(x - 1, y);
		sum = sum + getCell(x - 1, y + 1);
		// middle
		sum = sum + getCell(x, y - 1);
		sum = sum + getCell(x, y + 1);
		// bottom
		sum = sum + getCell(x + 1, y - 1);
		sum = sum + getCell(x + 1, y);
		sum = sum + getCell(x + 1, y + 1);

		return sum;
	}

	public int LiveOrDead(int x, int y) {
		int status = 0;
		int self = getCell(x, y);
		int neighbor = checkNeighborStatus(x, y);
		if (self == 1) {
			if (neighbor == 2 || neighbor == 3) {
				status = 1;
			}
			if (neighbor < 2 || neighbor > 3) {
				status = 0;
			}

		} else {
			if (neighbor == 3) {
				status = 1;
			} else {
				status = 0;
			}
		}

		return status;
	}

	public void setNextValue(int x, int y, int value) {
		next_area[x][y] = value;
	}

	public int getNextValue(int x, int y) {
		return next_area[x][y];
	}

	public void GenerateNext() {
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				int value = LiveOrDead(i, j);
				setNextValue(i, j, value);
			}
		}
	}

	public String PrintGenerateNext() {
		String result = "";
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				result = result + ("(" + i + "," + j + ")=" + getNextValue(i, j));
			}
			result = result + "\n";
		}
		return result;
	}
}
