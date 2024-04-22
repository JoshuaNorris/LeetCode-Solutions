package node;

public class Node<E> {

	private int priority;
	private E object;

	public Node(int priority, E object) {
		this.priority = priority;
		this.object = object;
	}

	public int getPriority() {
		return this.priority;
	}

	public boolean equals(Node<E> other) {
		return (
			this.priority == other.priority &&
			this.object == other.object
		);
	}


}