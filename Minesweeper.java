public class Minesweeper {

	public static void main(String[] args) {

		System.out.println("Unesite Duzinu");
		int duzina = TextIO.getInt();
		System.out.println("Unesite Sirinu");
		int sirina = TextIO.getInt();
		int counter = 0;

		int niz[][] = kreiraj(duzina, sirina);
		int brojMina = (int) ((duzina * sirina) * 0.30);
		ispis(niz);
		poredajMine(niz, brojMina);
		ispis(niz);
		povratBrojeva(niz);

		ispis(niz);

		int[][] prazno = new int[duzina][sirina];
		for (int i = 0; i < prazno.length; i++) {
			for (int j = 0; j < prazno.length; j++) {
				prazno[i][j] += -3;
			}
		}

		do {
			try {
				ispis(prazno);
				System.out.println("Unesite Koordinatu X");
				int X = (TextIO.getInt()) - 1;
				System.out.println("Unesite Koordinatu y");
				int Y = (TextIO.getInt()) - 1;
				prazno[X][Y] = niz[X][Y];

				if (niz[X][Y] == -1) {
					System.out.println("Zao mi je izgubili ste");
					System.out.println("");
					ispis(prazno);
					break;
				}
				counter++;
				if ((duzina * sirina) - brojMina == counter) {
					System.out.println("Cestitam pobjedili ste!");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Zao mi je vrijednosti nisu validne");
			}
		} while (brojMina > 0);

	}

	public static int[][] kreiraj(int duzina, int sirina) {
		int[][] gotovNiz = new int[duzina][sirina];
		return gotovNiz;
	}

	public static int randomMine(int pocetak, int kraj) {
		int randomJedan = (int) (pocetak + (Math.random()) * (kraj - pocetak));
		return randomJedan;
	}

	public static void poredajMine(int[][] velicinaTable, int brojMina) {

		while (brojMina > 0) {
			int x = randomMine(0, velicinaTable.length);
			int y = randomMine(0, velicinaTable.length);

			if (velicinaTable[x][y] == 0) {
				velicinaTable[x][y] = -1;
				brojMina = brojMina - 1;
			}

		}

	}

	public static void povratBrojeva(int[][] tabla)

	{
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				if (tabla[i][j] == -1) {
					int pocI = i - 1;
					int krajI = pocI + 2;

					int pocJ = j - 1;
					int krajJ = pocJ + 2;

					if (pocI < 0) {
						pocI = 0;
					}

					if (pocJ < 0) {
						pocJ = 0;
					}

					if (krajI >= tabla.length) {
						krajI = tabla.length - 1;
					}

					if (krajJ >= tabla.length) {
						krajJ = tabla.length - 1;
					}

					for (int k = pocI; k <= krajI; k++) {

						for (int m = pocJ; m <= krajJ; m++) {
							if (tabla[k][m] != -1) {
								tabla[k][m]++;
							}
						}
					}
				}

			}
		}

	}

	public static void ispis(int ulazNiz[][]) {
		for (int i = 0; i < ulazNiz.length; i++) {
			System.out.print("|");

			for (int j = 0; j < ulazNiz[i].length; j++) {
				if (ulazNiz[i][j] == -3) {
					System.out.printf("   |");
				} else {
					System.out.printf("%2d |", ulazNiz[i][j]);
				}
			}
			System.out.println();

		}
		System.out.println();
	}

}