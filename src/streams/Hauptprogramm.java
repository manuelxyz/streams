
package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

/**
 * @author ######
 * @author ########
 *
 */
public class Hauptprogramm {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,19,10,2,27);
		
		// Aufgabe 1.
		Stream<Integer> sortedAndDestinct = list.stream().distinct().sorted();
		showDialog(sortedAndDestinct, "Aufgabe1");
		
		//Aufgabe 2
		Predicate<Integer> filter = n -> n % 2 == 0 ;
		Stream<Integer> ergebnis2 = list.stream().filter(filter).distinct().sorted();
		showDialog(ergebnis2, "Aufgabe 2");
		
		// Aufgabe 3
		Predicate<Integer> filter2 = n -> n % 2 != 0 ;
		int ergebnis3 = list.stream().filter(filter2).distinct().sorted().mapToInt( n -> n).sum();
		JOptionPane.showMessageDialog(null, "Summe: " + ergebnis3, "Aufgabe 3", JOptionPane.INFORMATION_MESSAGE);
		
	}

	private static void showDialog(Stream<Integer> sortedAndDestinct, String title) {
		JOptionPane.showMessageDialog(null, "Cleaned: \n" + sortedAndDestinct.map(Object::toString).collect(Collectors.joining(", ")), title, JOptionPane.INFORMATION_MESSAGE);
	}

}
