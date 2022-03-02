package pack_GUI;


public class Book 
{
	private String title;
	private String author;
	private String publisher;
	private int numPages;
	private int numCopies;
	private String rentedBy;
	
	public Book (String t, String a, String p, int pg, int c, String cust)
	{
		this.title = t;
		this.author = a;
		this.publisher = p;
		this.numPages = pg;
		this.numCopies = c;
		this.rentedBy = cust;
	}
	
	public String info()
	{
		String s = ("Title " + this.title + " Author: " + this.author + " Publisher: " + this.publisher +
				" Number of pages: " + this.numPages + " Number of copies: " + this.numCopies);
		return s;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getAuthor() 
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	public int getNumPages() 
	{
		return numPages;
	}
	public void setNumPages(int numPages) 
	{
		this.numPages = numPages;
	}
	public int getNumCopies() 
	{
		return numCopies;
	}
	public void setNumCopies(int numCopies) 
	{
		this.numCopies = numCopies;
	}

	public String getRentedBy() 
	{
		return rentedBy;
	}

	public void setRentedBy(String rentedBy) 
	{
		this.rentedBy = rentedBy;
	}
}
