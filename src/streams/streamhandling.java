
package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

/**
 * @author ######
 * @author ########
 *
 */
public class streamhandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		char wahl = ' ';
		int result = JOptionPane.showConfirmDialog(null, "Ausgabe auf der Konsole? (Alternative: JOptionPane)");
		if(result == JOptionPane.YES_OPTION) {
			wahl = 'k';
		}
		else if(result == JOptionPane.NO_OPTION) {
			wahl = 'p';
		}
		else {
			JOptionPane.showMessageDialog(null, "Programm wird beendet...!");
			System.exit(0);
		}
		
		// Aufgaben zum Streamhandling: zur Kontrolle bitte jeweils auf der Konsole ausgeben
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		
		// A1) Zählen der leeren String
		Predicate<String> filterA1 = n -> n == "";
		long ergebnisA1 = strList.stream().filter(filterA1).count();
		showContent(wahl, "Anzahl leerer Strings: " + ergebnisA1, "Aufgabe 1");

		// A2) Zählen der Strings mit mehr als 3 Buchstaben
		Predicate<String> filterA2 = n -> n.length() > 3;
		long ergebnisA2 = strList.stream().filter(filterA2).count();
		showContent(wahl, "Anzahl Strings > 3 Buchstaben: " + ergebnisA2, "Aufgabe 2");
		
		// A3) Zählen der Strings, die mit dem Buchstaben "a" beginnen
		Predicate<String> filterA3 = n -> n.startsWith("a");
		long ergebnisA3 = strList.stream().filter(filterA3).count();
		showContent(wahl, "Anzahl Strings (beginnt mit A): " + ergebnisA3, "Aufgabe 3");
		
		// A4) Neue Liste erstellen ohne die leeren String
		List<String> newListA4 = strList.stream().filter(n -> n != "").collect(Collectors.toList());
		showContent(wahl, "Neue Liste ohne leeren String:\n\tVorher: " + strList + "\n\tNachher: " + newListA4, "Aufgabe 4");

		// Liste für A5)
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");

		//A5) String erstellen, der die Alt-Listeneinträge in Großbuchstaben enthält
		String entrys = G7.toString().toUpperCase();
		showContent(wahl, "String mit Einträge in Großbuchstaben:\n\tVorher: " + G7 + "\n\tNachher: " + entrys, "Aufgabe 5");
		
		// Liste für A6)
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

		//A6) Liste erstellen mit den einmaligen Quadratzahlen der Alt-Liste
		List<Integer> newListA6 = numbers.stream().mapToInt(n->n*n).mapToObj(n->n).collect(Collectors.toList());
		showContent(wahl, "Neue Liste mit Quadratzahlen der Alt-Liste:\n\tVorher: " + numbers + "\n\tNachher: " + newListA6, "Aufgabe 6");
	}
	
	/**
	 * Gibt das Resultat auf der Konsole oder als JOptionPane aus
	 * 
	 * @param wahl Auswahl ob Konsole / JOptionPane
	 * @param text Anzuzeigender Text
	 * @param title Anzuzeigender Titel
	 */
	private static void showContent(char wahl, String text, String title) {
		String w = String.valueOf(wahl);
		if(w.equalsIgnoreCase("k")) {
			System.out.println("\n" + title + ":\n\t" + text);
		}
		else {
			JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
