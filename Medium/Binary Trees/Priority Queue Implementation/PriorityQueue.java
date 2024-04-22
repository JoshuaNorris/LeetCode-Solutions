import node.Node;
import java.util.ArrayList;



public class PriorityQueue<E> {

	private ArrayList<Node<E>> queue = new ArrayList<>();

	public PriorityQueue (Node<E> root) {
	}

	public void insert(Node<E> node) {
		queue.add(node);
		int node_index = queue.size() - 1;
		while (true) {
			Node<E> parent = getParent(node_index);
			int parent_index = getParentIndex(node_index);

			if (node_index == 0) {
				break;
			}
			
			if (node.getPriority() < parent.getPriority()) {
				switchParentandChild(node, parent, node_index, parent_index);
				node_index = parent_index;
			} else {
				break;
			}
		}
	}



	public void delete(Node<E> node) {
		if (this.isEmpty()) {
			throw new NullPointerException("This queue is empty and cannot be deleted from.");
		}
		Node<E> last_element = this.queue.remove(this.queue.size());
		int node_index = getNodeIndex(node);
		this.queue.set(node_index, last_element);


		while (true) {
			Node<E> parent = getParent(node_index);
			int parent_index = getParentIndex(node_index);

			int left_child_index = getLeftChildIndex(node_index);
			int right_child_index = getLeftChildIndex(node_index);

			if (parent.getPriority() < last_element.getPriority()) {
				switchParentandChild(last_element, parent, node_index, parent_index);
				node_index = parent_index;
			} else if (left_child_index < this.queue.size()) {
				Node<E> left_child = this.queue.get(left_child_index);
				if (left_child.getPriority() > last_element.getPriority()) {
					switchParentandChild(left_child, last_element, left_child_index, node_index);
					node_index = left_child_index;
				}
			}  else if (right_child_index < this.queue.size()) {
				Node<E> right_child = this.queue.get(right_child_index);
				if (right_child.getPriority() > last_element.getPriority()) {
					switchParentandChild(right_child, last_element, right_child_index, node_index);
					node_index = right_child_index;
				}
			} else {
				break;
			}
		}


	}





	private int getNodeIndex(Node<E> node) {
		for (int x = 0; x < this.queue.size(); x++) {
			if (queue.get(x).equals(node)) {
				return x;
			}
		} return -1;
	}

	private Node<E> getParent(int childIndex) {
		return this.queue.get(Math.floorDiv((childIndex - 1), 2));
	}

	private static int getParentIndex(int childIndex) {
		return Math.floorDiv((childIndex - 1), 2);
	}

	private Node<E> getLeftChild(int parentIndex) {
		return this.queue.get(getLeftChildIndex(parentIndex));
	}

	private static int getLeftChildIndex(int childIndex) {
		return (childIndex * 2) + 1;
	}

	private Node<E> getRightChild(int parentIndex) {
		return this.queue.get(getRightChildIndex(parentIndex));
	}

	private static int getRightChildIndex(int childIndex) {
		return (childIndex * 2) + 2;
	}

	private void switchParentandChild(Node<E> child, Node<E> parent, int child_index, int parent_index) {
		this.queue.set(parent_index, child);
		this.queue.set(child_index, parent);
	}

















	public boolean isEmpty() { return this.queue.size() == 0; }

	// public Node<E> peek() { return new Node(); }

	private int getFullLayers() {
		return (int) (Math.log(this.queue.size()) / Math.log(2)) + 1;
	}
}