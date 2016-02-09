import java.util.PriorityQueue;
import java.util.HashMap;

/**
Creating a HumanTree using the HuffmanNode. Huffman Code works by first taking a String, 
counting the frequency of each letter in that String and placing all that information in a 
map that way you can have random access. Then you take the information in the map and put 
it in a priorityQueue. Once the all the nodes are in a priorityQueue then the top two items 
on the top Queue (characters with lowest frequency) are combined together and then placed 
back into the Queue. The program repeats this process until there is only one node in the 
Queue. This last node is then set as the root of the tree. As this process is happening the 
nodes are automatically formed into a tree because when two nodes are combined the combination 
is used as the parent node and the two other nodes are set to the left and right of that 
parent, so in the end everything is connected.
@author Yanni Angelides
@version 01/27/16
*/

//I used a HashMap because the order that the characters are in doesn't really matter because 
//they are going to be reordered in the Priority Queue any way. Also, because the program will 
//have to look through the whole map to find characters and add to their count there is no point 
//of wasting time sorting the tree to make the program faster.

public class HuffmanTree
{
	private HuffmanNode root;
	private HashMap<String, Integer> map;
	private PriorityQueue<HuffmanNode> que;
	
	//Constructor
	public HuffmanTree(String str)
	{
		createTree(str);
	}
	
	//method that initializes the string and puts the iterates through the initially sentence to find all the characters and their frequencies
	
	/**
	Uses helper methods to create map of the values and count of the different characters in sentence, creates a Priority Queue using that map, then uses the PriorityQueue to create HashTree
	*/
	public void createTree(String sentence)
	{
		this.makeMap(sentence);
		this.makeQueue();
		//makeTree();
	}
	
	public void makeMap(String str)
	{
		map = new HashMap<String, Integer>();
		for(int i = 0; i < str.length(); i++)
		{
			char a = str.charAt(i);
			String let = a.toString();
			if(map.containsValue(let))
			{
				int save = map.get(let);
				map.remove(let);
				map.put(let, save + 1);
			}
			else
			{
				map.put(let, 1);
			}
		}
	}
	
	public void makeQueue()
	{
		que = new PriorityQueue<HuffmanNode>();
		Object[] arr = map.keySet().toArray();
		for (int i = 0; i < arr.length; i++)
		{
			HuffmanNode node = new HuffmanNode(arr[i].toString(), map.get(arr[i]));
			que.offer(node);
		}
		while(que.peek() != null)
		{
			System.out.println(que.poll());
		}
	}
	
	public void makeTree()
	{
		while (que.size() > 1)
		{
			HuffmanNode node1 = que.poll();
			HuffmanNode node2 = que.poll();
			HuffmanNode combo = new HuffmanNode(node1, node2);
			que.offer(combo);
		}
		root = que.poll();
	}
	
	/**
	Creates a String of 1s and 0s that represents a the String parameter based upon the original HuffmanTree 
	*/
	public String encode(String str)
	{
		String code = "";
		for (int i = 0; i < str.length(); i++)
		{
			code += helper(""+str.charAt(i));
		}
	}
	
	public boolean contains(String a, String b)
	{
		for(int i = 0; i < b.length(); i++)
		{
			if(a.equals(""+b.charAt(i)) == true)
			{
				return true;
			}
		}
		return false;
	}
	
	public String helper(String str)
	{
		if(this.getRight() == null && this.getLeft() == null)
		{
			return "";
		}
		if(contains(str, this.getRight().getValue()))
		{
			return "1" + this.getRight().helper(str);
		}
		else
		{
			return "0" + this.getLeft().helper(str);
		}
	}
	
	/**
	Takes in a String of ones and zeros and using the HuffmanTree creates a new string of actual letters that those ones and zeros encode for 
	public void decode(String str)
	*/
	pubic String decode(String str)
	{
		if(this.getRight() == null && this.getLeft() == null)
		{
			return this.getValue();
		}
		if
		{
			
		}	
	}
}