import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\foreign_names.csv";
        String separator = ";";
        List <Person> personList = new ArrayList <> ();
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(filePath)){
            CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(new FileReader(filePath));
            CSVReader csvReader = csvReaderBuilder.withSkipLines(1).build();
            if (csvReader == null)
                throw new FileNotFoundException(filePath);
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null){
                nextLine = nextLine[0].split(separator);
                if(nextLine.length > 2){
                    Person person = new Person(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[5], new Division(nextLine[4].charAt(0) - 'A', nextLine[4]));
                    personList.add(person);
                }
            }
        }
        catch(FileNotFoundException | CsvValidationException e){
            e.printStackTrace();
        }
        finally {
            for(int i = 1; i < personList.size(); i++){
                System.out.print(personList.get(i).getId() + "\t \t");
                System.out.print(personList.get(i).getName() + "\t \t");
                System.out.print(personList.get(i).getSex() + "\t \t");
                System.out.print(personList.get(i).getDate() + "\t \t");
                System.out.print(personList.get(i).getDiv().divGetName() + "\t \t");
                System.out.print(personList.get(i).getDiv().divGetId() + "\t \t");
                System.out.print(personList.get(i).getSalary() + "\t \t");
                System.out.println();
            }
        }
    }
}