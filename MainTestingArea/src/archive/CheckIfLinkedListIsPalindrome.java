package archive;

public class CheckIfLinkedListIsPalindrome {
	static boolean flag = true;

	public static void main(String[] args) {
		CheckIfLinkedListIsPalindrome maine = new CheckIfLinkedListIsPalindrome();
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		node root = new node(arr[0]);
		node tail = root;
		for (int i = 1; i <= arr.length - 1; i++) {
			tail.extedTail(new node(arr[i]));
		}
		// printLL(root);

		maine.isPalindrome(root);
		System.out.println(flag);
	}

	private static node printLL(node nod) {
		while (nod != null) {
			System.out.println(nod.data);
			nod = nod.next;
		}
		return nod;
	}

	private node isPalindrome(node n) {
		node n1;
		if (n.next == null) {
			System.out.println("->" + n.data);
			return n;
		} else {
			n1 = isPalindrome(n.next);
			if (!n.equals(n1)) {
				System.out.println(n.data + " " + n1.data);
				flag = false;
			}
		}
		System.out.println("-<" + n.data);
		return n;
	}
}

class node {
	public node(int a) {
		this.data = a;
		next = null;
	}

	node next;
	int data;

	void extedTail(node in) {
		node temp = this;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = in;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		node other = (node) obj;
		if (data != other.data)
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}
}