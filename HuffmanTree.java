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
	//first HuffmanNode of the Huffman Tree, start of the tree
	private HashMap<String, Integer> map;
	//map that stores the count values of all the different characters in the master String, stores how many times each character appears
	private PriorityQueue<HuffmanNode> que;
	//sorts the values in the HashMap in an order from least to greatest so that they can be added to the tree
	
	//Constructor
	public HuffmanTree(String str)
	{
		createTree(str);
	}
	
	/**
	Uses helper methods to create map of the values and count of the different characters in sentence, creates a Priority Queue using that map, then uses the PriorityQueue to create HashTree
	@param String sentence, master String that is going to be used to create the Huffman Tree
	*/
	public void createTree(String sentence)
	{
		this.makeMap(sentence);
		this.makeQueue();
		this.makeTree();
		//Three methods above are helper methods used to create the tree
	}
	
	/**
	method that initializes the string and iterates through the initial sentence to find all the characters and their frequencies
	@param String str, master String that is passed into the createTree method
	@return
	*/
	public void makeMap(String str)
	{
		map = new HashMap<String, Integer>();
		for(int i = 0; i < str.length(); i++)
		{
			String let = "" + str.charAt(i);
			//converting the first character of the String into a String so it is easier to work with
			if(map.containsKey(let))
			{
				int save = map.get(let);
				map.remove(let);
				map.put(let, save + 1);
				//there is no set method for HashMaps so you have to remove the old HashMap node add one to its count and then add it back into the HashMap again
			}
			else
			{
				map.put(let, 1);
			}
		}
	}
	
	/**
	Creates a Queue out of the different nodes in the HashMap
	*/
	public void makeQueue()
	{
		que = new PriorityQueue<HuffmanNode>();
		Object[] arr = map.keySet().toArray();
		//keySet method for HashMap returns a Set of the Key values in the HashMap then the toArray method converts that Set into an Array which is a data structure I am more familiar with
		for (int i = 0; i < arr.length; i++)
		{
			HuffmanNode node = new HuffmanNode(arr[i].toString(), map.get(arr[i]));
			que.offer(node);
		}
	}
	
	/**
	Creates a type of BinaryTree out of HuffmanNodes with root as the start of the tree
	*/
	public void makeTree()
	{
		while (que.size() > 1)
		{
			HuffmanNode node1 = que.poll();
			HuffmanNode node2 = que.poll();
			//takes two nodes out of the que and puts them in the tree
			HuffmanNode combo = new HuffmanNode(node1, node2);
			//combines the two nodes together using a specialized constructor from the HuffmanNode class
			que.offer(combo);
			//puts the now combined node back into the Queue
		}
		root = que.poll();
		//last object in the Queue is used as the start of the tree
	}
	
	/**
	Creates a String of 1s and 0s that represents a the String parameter based upon the original HuffmanTree
	@param String str, String that is passed in that needs to be encoded
	@return String of ones and zeros that is based upon the tree created with the master String that acts as the code for the parameter String 
	*/
	public String encode(String str)
	{
		String code = "";
		for (int i = 0; i < str.length(); i++)
		{
			code += helper(""+str.charAt(i), root);
			//calls helper method that actually encodes each individual letter of the String
		}
		return code;
	}
	
	/**
	Helper method that takes in two Strings, String a being a letter and String b being an combination of letters, and checks if String b contains a
	@param String a, one letter String, String b combination of letters that is being checked
	@return boolean determining if String b contains String a
	*/
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
	
	/**
	Helper method that takes in a String and iterates through the HuffmanTree to track a path to that individual letter 
	@param String str, that is being checked for, HuffmanNode n, that is being checked for that individual letter
	@return
	*/
	public String helper(String str, HuffmanNode n)
	{
		if(n.getRight() == null && n.getLeft() == null)
		//if the the iterator hits a "Leaf" or a node where both left and right values are null it means that it has hit the letter it is looking for and returns a blank String
		{
			return "";
		}
		if(contains(str, n.getRight().getValue()))
		//if the iterator sees that the letter it is looking for is contained in the right value of the Huffman node it is on it will continue down the right side of the tree and add a 1 to the String
		{
			return "1" + helper(str, n.getRight());
		}
		else
		//if the iterator sees that the letter it is looking for is contained in the left value of the Huffman node it is on it will continue down the left side of the tree and add a 0 to the String
		{
			return "0" + helper(str, n.getLeft());
		}
	}
	
	/**
	Takes in a String of ones and zeros and using the HuffmanTree creates a new string of actual letters that those ones and zeros encode for 
	@param String str, of ones and zeros that code for a message
	@return String, that the 1s and 0s encode for
	*/
	public String decode(String str)
	{
		int i = 0;
		String code = "";
		while(i < str.length())
		//makes sure the method iterates through all the 1s and 0s in the str parameter
		{
			HuffmanNode node = root;
			//resets the node variable to the start of the tree
			while(node.getRight() != null && node.getLeft() != null)
			//will keep iterating through the tree until it hits a "leaf" node where both left and right are null
			{
				String let = "" + str.charAt(i);
				//variable that iterates through all the 1s and 0s
				if(let.equals("1"))
				{
					node = node.getRight();
					//Based on the encode method if there is a one in the String then the the code should iterate right
				}
				else
				{
					node = node.getLeft();
					//if let = 0 should iterate to the left
				}
				i++;
			}
			code += node.getValue();
			//when both left and right are null the iterator should be at the letter it is looking for
		}
		return code;
	}
}