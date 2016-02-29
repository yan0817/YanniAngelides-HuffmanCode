import java.util.PriorityQueue;
import java.util.HashMap;
/**
Creating Huffman Code Program
@author Yanni Angelides
@version 01/27/16
*/

public class HuffmanNode implements Comparable
{
	protected HuffmanNode left;
	//daughter HuffmanNode that is contained in a memory space to the "left" of this one or the parent one
	protected HuffmanNode right;
	//daughter HuffmanNode that is contained in a memory space to the "right" of this one or the parent one
	protected String value;
	//String the the Huffman node stores, its actual value
	protected int count;
	//tracks the amount of times the value of the HuffmanNode appears in the master String
	
	/**
	Basic constructor that just sets the value of the HuffmanNode to a specified String
	@param String val, specified value for the value class field
	*/
	public HuffmanNode(String val)
	{
		left = null;
		right = null;
		value = val;
		count = 1;	
	}
	
	/**
	Combines the values and counts of two HuffmanNode and makes them into one single HuffmanNode
	@param HuffmanNode a, HuffmanNode b two HuffmanNodes that are being combined 
	*/
	public HuffmanNode(HuffmanNode a, HuffmanNode b)
	{
		left = a;
		right = b;
		value = a.getValue() + b.getValue();
		count = a.getCount() + b.getCount();
	}
	
	/**
	Constructor that sets both the value and the count to the specified parameter
	@parameter String val, String that value is set to, int c, int count is set to
	*/
	public HuffmanNode(String val, int c)
	{
		left = null;
		right = null;
		value = val;
		count = c;
	}
	
	/**
	Gets the count of the specified HuffmanNode
	@return int, value of the count
	*/
	public int getCount()
	{
		return count;
	}
	
	/**
	Sets the value of the count
	@param int num, count is set to
	*/
	public void setCount(int num)
	{
		count = num;
	}
	
	/**
	Gets the value of the specified HuffmanNode
	@return String, value of the HuffmanNode
	*/
	public String getValue()
	{
		return value;
	}
	
	/**
	Sets the value to the specified String
	@param String str, that value is set to
	*/
	public void setValue(String str)
	{
		value = str;
	}
	
	/**
	gets the value of the HuffmanNode to the left
	@return value of the HuffmanNode to the left
	*/
	public HuffmanNode getLeft()
	{
		return left;
	}
	
	/**
	gets the value of the HuffmanNode to the right
	@return value of the HuffmanNode to the right
	*/
	public HuffmanNode getRight()
	{
		return right;
	}
	
	/**
	Sets the value of the HuffmanNode on the left
	@param HuffmanNode node, that the left value is set to 
	*/
	public void setLeft(HuffmanNode node)
	{
		left = node;
	}
	
	/**
	Sets the value of the HuffmanNode on the right
	@param HuffmanNode node, that the right value is set to 
	*/
	public void setRight(HuffmanNode node)
	{
		right = node;
	}
	
	/**
	Compares two HuffmanNodes based on their count value, if the counts are the same zero is returned, if the first is bigger than the second it returns a positive number if the opposite is true it returns a negative value
	@param object node, that is being compared
	*/
	public int compareTo(Object node)
	{
		return count - (((HuffmanNode)node).getCount());
	}
	
	/**
	Creates a String representation of a HuffmanNode
	@return String, representation of a HuffmanNode
	*/
	public String toString()
	{
		String str = "Value: " + value + " Count: " + count;
		return str;
	}
}