package pack_GUI;

public class Customer 
{
	private String firstName;
	private String lastName;
	private String email;
	
	public Customer(String f, String l, String e)
	{
		this.firstName = f;
		this.lastName = l;
		this.email = e;
	}
	
	public String info()
	{
		String s = ("Name: " + this.firstName + " " + this.lastName + " Email: " + this.email);
		return s;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
}
