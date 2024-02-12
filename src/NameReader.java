import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class NameReader {
    public static void main(String[] args) {
        final String fileName = "namespl.txt";
       TreeSet<String> names = new TreeSet<>(new Comparator<String>() {
           @Override
           public int compare(String s1, String s2) {
               return -s1.compareTo(s2);     //odwrotny porządek
           }
       });

       try (Scanner sc = new Scanner( new File(fileName))) {
           while (sc.hasNextLine()){   //dodawanie unikalnych elementów
           names.add(sc.nextLine());
       }
       System.out.println("Liczna imion w zbiorze: "+ names.size());
           System.out.println("Pierwsze imię: "+ names.first());
           System.out.println("Ostatnie imię: "+ names.last());



       } catch (FileNotFoundException e) {
           System.err.println("Brak pliku"+ fileName);
       }

    }
}