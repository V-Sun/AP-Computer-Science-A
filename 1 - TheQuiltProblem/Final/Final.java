import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BenchmarkFour {
	public static void main(String args[]) {
		File file = new File("./Pattern");
		try {
			Scanner fileReader = new Scanner(file);
			int length = fileReader.nextInt();
			int width = fileReader.nextInt();
			int numberRows = fileReader.nextInt();
			int numberColumns = fileReader.nextInt();
			fileReader.nextLine();
			char[][] array = new char[length][width];
			for(int x = 0; x < length; x++) {
				String line = fileReader.nextLine();
				for (int y = 0; y < width; y++ ) {
					array[x][y] = line.charAt(y);
				}
			}
			char[][] reverse = new char[length][width];
			for(int i = 0; i < length; i++) {
				reverse[i] = array[array.length - 1 - i];
				}
			
			
			char[][] total = new char[length * numberRows][width * numberColumns];
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < width; j++) {
					for(int x = 0; x < numberRows; x++) {
						for(int y = 0; y < numberColumns; y++) {
							if((x+y) % 2 == 0) {
								total[i + length * x][j + width * y] = array[i][j];
							}
							else {
								total[i + length * x][j + width * y] = reverse[i][j];
							}
						}
						
					}
				}
			}
			for(int i = 0; i < total.length; i++) {
				System.out.println(total[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println();
		
	}
}
