package Candidate;

public class ExperienceCandidate extends Candidate {
	
	private int  expInYear;
	


	public ExperienceCandidate(String firstname, String lastname, String phone, String email, int expInYear) {
		super(firstname, lastname, phone, email);
		this.expInYear = expInYear;
	}
	

	@Override
	public String toString() {
		return "ExperienceCandidate [expInYear=" + expInYear + "]";
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "experience";
	}
	

	
	

}
