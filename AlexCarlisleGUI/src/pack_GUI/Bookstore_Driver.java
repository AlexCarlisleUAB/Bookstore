package pack_GUI;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore_Driver
{
	private static ArrayList<Book> bList;
	private static ArrayList<Book> rentList;
	private static ArrayList<Customer> cList;
	
	public static void displayBList()
	{
		int count;
		for(count = 0; count < bList.size(); count++)
		{
			Book b = bList.get(count);
			System.out.println(b.info());
		}
	}
	
	public static void displayCList()
	{
		int count;
		for(count = 0; count < cList.size(); count++)
		{
			Customer c = cList.get(count);
			System.out.println(c.info());
		}
	}
	
	public static Book bookSearch(String t)
	{
		int count;
		boolean found = false;
		Book temp = null;
		for(count = 0; count < bList.size(); count++)
		{
			temp = bList.get(count);
			if (t.equals(temp.getTitle()))
			{
				found = true;
				return temp;
			}
		}
		if (!found)
		{
			System.out.println("Book not found.");
			return null;
		}
		return temp;
			
		
	}
	
	public static Customer customerSearch(String c)
	{
		int count;
		Customer temp = null;
		for(count = 0; count < cList.size(); count++)
		{
			temp = cList.get(count);
			if (c.equals(temp.getLastName()))
			{
				return temp;
			}
		}
		System.out.println("Customer not found.");
		return null;	
		
	}
	
	public static void rentBook(Book b, String c)
	{
		bList.remove(b);
		rentList.add(b);
		b.setRentedBy(c);
		System.out.println("Success! Book is now rented by: " + b.getRentedBy());
	}
	
	public void returnBook(Book b)
	{
		bList.add(b);
		bList.remove(b);
		b.setRentedBy("");
		System.out.println("Success! Book returned.");
	}
	
	public static Book displayBooksByCustomer(String c)
	{
		int count;
		Book temp = null;
		for(count = 0; count < rentList.size(); count++)
		{
			temp = rentList.get(count);
			if (c.equals(temp.getRentedBy()))
			{
				return temp;
			}
		}
		System.out.println("Book not found.");
		return null;	
		
	}
	
	public static void main (String[] args)
	{
		bList = new ArrayList<Book>();
		cList = new ArrayList<Customer>();
		rentList = new ArrayList<Book>();
		
		Book b = new Book("title", "author", "publisher", 189, 23, "Library");
		Book b2 = new Book("Long book", "Great Author", "Good publisher", 397, 8, "Library");
		Book b3 = new Book("Short Book", "Bad Author", "Ok publisher", 103, 35, "Library");
		Customer c = new Customer("Alex", "Carlisle", "alex1717@uab.edu");
		bList.add(b);
		bList.add(b2);
		bList.add(b3);
		cList.add(c);
		
		Scanner kb = new Scanner(System.in);
		
		JFrame f = new JFrame();
		f.setTitle("Bookstore GUI");
		f.setSize(1000,1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		
		JLabel label = new JLabel("Welcome to the Bookstore GUI! Please"+ 
				" choose one of the following:");
		label.setBounds(100, 30, 500, 30);
		panel1.add(label);
		
		JButton button = new JButton("Display Book List");
		button.setBounds(100,80,800,100);
		panel1.add(button);
		button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Bookstore_Driver.displayBList();
				}
			});
		
		JButton button2 = new JButton("Display Customer List");
		button2.setBounds(100,230,800,100);
		panel1.add(button2);
		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Bookstore_Driver.displayCList();
			}
		});
		
		JButton button3 = new JButton("Book Search");
		button3.setBounds(100,380,800,100);
		panel1.add(button3);
		button3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Please insert the name of the book: ");
				String n = kb.nextLine();
				Book b = bookSearch(n);
				System.out.println(b.info());
			}
		});
		
		JButton button4 = new JButton("Customer Search");
		button4.setBounds(100,530,800,100);
		panel1.add(button4);
		button4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Please insert the name of the Customer: ");
				String n = kb.nextLine();
				Customer c = customerSearch(n);
				System.out.println(c.info());
			}
			
		});
				
	
		
		JButton button5 = new JButton("Rent Book");
		button5.setBounds(100,680,800,100);
		panel1.add(button5);
		button5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Enter the book title");
				String t = kb.nextLine();
				System.out.println("Enter the customer's last name");
				String n = kb.nextLine();
				Book book = bookSearch(t);
				rentBook(book, n);
			}
		});

		
		JButton button6 = new JButton("Display Books Rented By Customer");
		button6.setBounds(100,830,800,100);
		panel1.add(button6);
		button6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Enter the last name of the Customer");
				String n = kb.nextLine();
				Book b = displayBooksByCustomer(n);
				System.out.println(b.info());
			}
		});
		
		f.add(panel1);
		f.setVisible(true);
	}
}
