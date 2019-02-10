package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="musicians")
public class BandMember {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MUSICIANID")
	private int id;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="INSTRUMENT")
	private String instrument;
	@Column(name="BANDNAME")
	private String bandName;

	public BandMember() {
		super();
	}	


	public BandMember(String first, String last, String instrument) {
		super();

		this.firstName = first;
		this.lastName = last;
		this.instrument = instrument;
	}

	public BandMember(String firstName, String lastName, String instrument, String bandName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
		this.bandName = bandName;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}	
	
	public String getBandName() {
		return bandName;
	}
	
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	
	public String memberDetails() {
		return firstName + " " + lastName + " plays " + instrument + " in " + bandName + "\n";
	}
	
}
