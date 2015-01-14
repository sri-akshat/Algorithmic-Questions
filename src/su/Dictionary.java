package su;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Dictionary {

	private static final String dictionaryKeywords = "hot,dot,dog,lot,log";
    static Map<String, List<String>> parentToChildMap = new HashMap<String, List<String>>();
	// static List<Node> rootNodes = new ArrayList<Node>();
	static Map<String, Node> nodesAddressMap = new HashMap<String, Node>();

	public static void main(String[] args) {
		String startString = "dgg";
		String endString = "tot";
		initializeparentToChildMap();
		for (Map.Entry<String, List<String>> entry : parentToChildMap
				.entrySet()) {
			System.out.println("Parent and its childs are " + entry.getKey()
					+ " " + entry.getValue().toString());
		}

		Node root = createNaryTreeForDictionaryWord(parentToChildMap.keySet()
				.iterator().next());
		if (root != null) {

			search(startString, endString);
		}
	}

	private static void search(String startString, String endString) {
		int count = -1;
		for (String parent : parentToChildMap.keySet()) {
			String headParent = parent;
			Map<String, DirectedTree> map = new HashMap<String, DirectedTree>();
			Queue queue = null;
			if (getNoOfDiffCharacters(startString, parent) == 1) {
				queue = new Queue();
				queue.setqKey(parent);
				int minimumCount = 1;
				Set<String> qSet = new HashSet<String>();
				qSet.add(parent);
				Queue head = queue;
				String transformation = "";
				System.out.println("...Start is " + parent);
				DirectedTree dct = null;

				while (queue != null) {
					dct = map.get(queue.getqKey());
					if (dct == null) {
						dct = new DirectedTree();
						dct.setKey(queue.getqKey());
						map.put(queue.getqKey(), dct);
					}

					Node parentNode = nodesAddressMap.get(parent);
					if (getNoOfDiffCharacters(endString, parentNode.getKey()) == 1) {

						System.out.println("....End node is " + parent);
						transformation = endString + ",";
						while (dct != null) {
							transformation += dct.getKey() + ",";
							System.out.println(dct.getKey());
							dct = dct.getParent();
							minimumCount++;
						}
						transformation += startString;
						System.out.println("Found transformation with length "
								+ ++minimumCount);
						System.out.println("Path is" + transformation);
						if (minimumCount > count)
							minimumCount = count;
						break;
					}
					for (Node childNode : parentNode.getChildNodes()) {
						Queue queueChildElement = null;
						if (!qSet.contains(childNode.getKey())) {
							qSet.add(childNode.getKey());
							while (head.getNext() != null) {
								head = head.next;
							}
							queueChildElement = new Queue();
							queueChildElement.setqKey(childNode.getKey());
							head.setNext(queueChildElement);
							DirectedTree child = new DirectedTree();
							child.setKey(childNode.getKey());
							dct.addChild(child);
							child.setParent(dct);
							if (map.get(child.getKey()) == null) {
								map.put(child.getKey(), child);
							}

						}
						System.out.println(queue);
					}
					if (queue != null) {
						queue = queue.getNext();
						if (queue != null) {
							parent = queue.getqKey();
						}
					}

				}

			}
		}
	}

	// create n ary by dfs
	/*
	 * private static Node createNaryTreeForDictionaryWord(String key,
	 * Set<String> parentsSet) { System.out.println("start key is"+key);
	 * System.out.println("PArents set size "+parentsSet.size()+
	 * " "+parentsSet.toString()); Node node = new Node(); parentsSet.add(key);
	 * if (parentToChildMap.get(key) != null) { node.setKey(key); } Node n =
	 * null; for (String child : parentToChildMap.get(key)) {
	 * System.out.println("Key is" +child); if (!parentsSet.contains(child)) { n
	 * = createNaryTreeForDictionaryWord(child, parentsSet); } }
	 * node.addChildNode(n);
	 * 
	 * return node; }
	 */
	// bfs tree creation
	private static Node createNaryTreeForDictionaryWord(String key) {
		Node root = null;
		Node treeHead = null;
		Set<String> qSet = new HashSet<String>();
		if ((key!=null) && !qSet.contains(key)) {
			qSet.add(key);
			Queue queueRootElement = new Queue();
			queueRootElement.setqKey(key);
			root = new Node();
			root.setKey(key);
			treeHead = root;
			if (nodesAddressMap.get(key) == null) {
				nodesAddressMap.put(key, root);
				System.out.println("Node created in graph");
			}
			while (queueRootElement != null) {
				root = nodesAddressMap.get(queueRootElement.qKey);

				Queue head = queueRootElement;
				Node childNode = null;
				for (String childKey : parentToChildMap.get(key)) {
					childNode = nodesAddressMap.get(childKey);
					if (childNode == null) {
						childNode = new Node();
						childNode.setKey(childKey);
						nodesAddressMap.put(childKey, childNode);
						System.out.println("Node created in graph");
					}
					Queue queueChildElement = null;
					if (!qSet.contains(childKey)) {
						qSet.add(childKey);
						while (head.getNext() != null) {
							head = head.next;
						}
						queueChildElement = new Queue();
						queueChildElement.setqKey(childKey);
						head.setNext(queueChildElement);

					}

					root.addChildNode(childNode);
				}

				if (queueRootElement != null) {
					queueRootElement = queueRootElement.getNext();
					if (queueRootElement != null) {
						key = queueRootElement.getqKey();
					}

				}

			}
		}
		return treeHead;
	}

	private static void initializeparentToChildMap() {
		String[] dictionaryWords = dictionaryKeywords.split(",");
		for (String keyword : dictionaryWords) {
			List<String> childs = null;
			for (String innerLoopKeyword : dictionaryWords) {
				if (!keyword.equalsIgnoreCase(innerLoopKeyword)) {
					int diffCharacters = getNoOfDiffCharacters(keyword,
							innerLoopKeyword);
					if (diffCharacters == 1) {
						if (parentToChildMap.get(keyword) == null) {
							childs = new ArrayList<String>();
						}
						childs.add(innerLoopKeyword);
						parentToChildMap.put(keyword, childs);
					}

				}
			}
		}
	}

	private static int getNoOfDiffCharacters(String keywordOne,
			String keywordOneTwo) {
		int count = 0;
		int index = 0;
		int lengthOfKeyword = keywordOne.length();
		while (lengthOfKeyword > 0) {
			if (keywordOne.charAt(index) != keywordOneTwo.charAt(index)) {
				count++;
			}
			index++;
			lengthOfKeyword--;
		}
		return count;
	}
}

class Node {
	String key;
	Set<Node> childNodes = new HashSet<Node>();
	Node parent = null;

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Set<Node> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(Set<Node> childNodes) {
		this.childNodes = childNodes;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void addChildNode(Node child) {
		childNodes.add(child);
	}
}

class Queue {
	String qKey;
	Queue next = null;

	public String getqKey() {
		return qKey;
	}

	public void setqKey(String qKey) {
		this.qKey = qKey;
	}

	public Queue getNext() {
		return next;
	}

	public void setNext(Queue next) {
		this.next = next;
	}
}

class DirectedTree {
	String key;
	Set<DirectedTree> childs = new HashSet<DirectedTree>();
	DirectedTree parent = null;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Set<DirectedTree> getChilds() {
		return childs;
	}

	public void setChilds(Set<DirectedTree> childs) {
		this.childs = childs;
	}

	public DirectedTree getParent() {
		return parent;
	}

	public void setParent(DirectedTree parent) {
		this.parent = parent;
	}

	public void addChild(DirectedTree node) {
		childs.add(node);
	}
}
