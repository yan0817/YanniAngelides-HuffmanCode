
/**
Creating Huffman Code Program
@author Yanni Angelides
@version 01/27/16
*/

public class HuffmanNode implements Comparable
{
	protected HuffmanNode left;
	protected HuffmanNode right;
	protected String value;
	protected int count;
	
	public HuffmanNode(String val)
	{
		left = null;
		right = null;
		value = val;
		count = 1;	
	}
	
	public HuffmanNode(HuffmanNode a, HuffmanNode b)
	{
		left = a;
		right = b;
		value = a.getValue() + b.getValue();
		count = a.getCount() + b.getCount();
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int num)
	{
		count = num;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public void setValue(String str)
	{
		value = str;
	}
	
	public HuffmanNode getLeft()
	{
		return left;
	}
	
	public HuffmanNode getRight()
	{
		return right;
	}
	
	public void setLeft(HuffmanNode node)
	{
		left = node;
	}
	
	public void setRight(HuffmanNode node)
	{
		right = node;
	}
	
	public int compareTo(Object node)
	{
		return count - (((HuffmanNode)node).getCount());
	}
}