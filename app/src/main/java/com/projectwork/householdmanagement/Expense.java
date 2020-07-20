package com.projectwork.householdmanagement;

public class Expense
{
	private String category;
	private int expense;

	
	Expense(String category, int expense)
	{
		this.category = category;
		this.expense = expense;

	}
	Expense() {
		// TODO Auto-generated constructor stub
	}

	public String getCategory()
	{
		return category;
	}
	
	int getExpense()
	{
		return expense;
	}
	


	public void setCategory(String category)
	{
		this.category = category;
	}
	
	void setExpense(int expense)
	{
		this.expense = expense;
	}
	
}
