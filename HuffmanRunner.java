import java.util.PriorityQueue;
import java.util.HashMap;
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
		HuffmanTree tree = new HuffmanTree("racecar racecar");
		String code = tree.encode("racecar race");
		System.out.println(code);
		System.out.println(tree.decode(code));
		HuffmanTree tree2 = new HuffmanTree("aaaabbc ddeeffgghijkklmnoopq rrsttuvwx xyyyyyyyyz!!!");
		String code2 = tree2.encode("yanni is the best coder ever!");
		System.out.println(code2);
		System.out.println(tree2.decode(code2));
			
	}
}