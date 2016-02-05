/**
Class that tests the methods of HuffmanNode
@author Yanni Angelides
@version 01/29/16
*/

public class HuffmanRunner
{
	public static void main(String [] args)
	{
		HuffmanNode node = new HuffmanNode("test");
		HuffmanNode node2 = new HuffmanNode("test");
		HuffmanNode node3 = new HuffmanNode("wrong");
		HuffmanNode node4 = new HuffmanNode(node, node3);
		System.out.println(node.compareTo(node2));
		System.out.println(node.compareTo(node3));
		while(que.peek() != null)
		{
			System.out.println(que.poll());
		}	
	}
}