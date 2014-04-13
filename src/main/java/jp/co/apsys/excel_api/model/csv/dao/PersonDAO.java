package jp.co.apsys.excel_api.model.csv.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.apsys.excel_api.model.csv.entity.Person;

import com.orangesignal.csv.filters.BeanExpressions;
import com.orangesignal.csv.manager.CsvEntityManager;

public class PersonDAO {

	public List<Person> list() {
		try {
			return new CsvEntityManager().load(Person.class).from(csvFile());
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Person>();
		}
	}
	
	public List<Person> listByName(String name) {
		try {
			if (name != null) {
				return new CsvEntityManager().load(Person.class).filter(BeanExpressions.eq("country", name)).from(csvFile());
			} else {
				return new CsvEntityManager().load(Person.class).from(csvFile());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Person>();
		}
	}

	private File csvFile() {
		String classpath = Thread.currentThread().getContextClassLoader().getResource("persons.csv").getPath();
		return new File(classpath);
	}
	
    public static void main(String[] args) throws IOException {
    	PersonDAO dao = new PersonDAO();
    	List<Person> persons = dao.list();
    	System.out.println(persons);
    }
}
