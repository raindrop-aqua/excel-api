package jp.co.apsys.excel_api.model.csv.entity;

import com.orangesignal.csv.annotation.CsvColumn;
import com.orangesignal.csv.annotation.CsvEntity;

@CsvEntity
public class Person {

	@CsvColumn(name = "User Id")
	public String userId;
	@CsvColumn(name = "Full Name")
	public String fullName;
	@CsvColumn(name = "Country")
	public String country;
	@CsvColumn(name = "Created At")
	public String createdAt;
	@CsvColumn(name = "Email")
	public String email;
}
