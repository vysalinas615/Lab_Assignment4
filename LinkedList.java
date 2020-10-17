import java.util.*;

public class LinkedList<E> //implements List<E>
{
	int someSize;

	private class Node<E>
	{
		E data;
		Node<E> next;

		public Node(E value) 
		{  
			data = value;
			next = null;
		}
	}

	private Node<E> head;
	private Node<E> tail; 

	public LinkedList()
	{
		head = new Node<E>(null);
		someSize = 0;
	}
	
	public int size()
	{
		return someSize;
	}

	public void add(E item)
	{
		Node<E> previous = new Node<E>(null); 
		previous = head;

		if (head == null)
		{
			head = new Node<E>(item);
			++someSize;
		}
		
		else
		{
			//prev = new Node<E>(head); 
			previous = head;
			while(previous.next != null)
			{
				previous = previous.next;
			}
		}

		Node<E> node = new Node<E>(item);
		previous.next = node;
		++someSize;
	}

	public void add(E item, int position)
	{
		if (position == 0)
		{
			Node<E> node = new Node(item);
			node.next = head;
			head = node;
			++someSize;
		}

		else
		{
			Node<E> previous = head;
			for (int i=0; i<position-1; i++)
			{
				previous = previous.next;
			}
			Node<E> node = new Node<E>(item);
			node.next = previous.next;
			previous.next = node;
			++someSize;
		}
	}

	public E remove(int position)
	{
		if (position == 0)
		{
			Node<E> node = head;
			head = head.next;
			--someSize;
			return node.data;
		}

		else
		{
			Node previous = head;
			for (int i=0; i<position-1; i++)
			{
				previous = previous.next;
			}
			Node<E> node = previous.next;
			previous.next = node.next;
			--someSize;
			return node.data;
		}
	}

	public E get(int position)
	{
		if (position<1 || position>=someSize)
		{
			return null;
		}
		Node<E> current = head;
		for (int i=0; i<position; i++)
		{
			current = current.next;
		}
	  return current.data;
	}

	public E reverse(E head)
	{
		//Node<E> aHead = new Node(head);
		//Node<E> previous = new Node(null);
		Node<E> previous = null;
		Node<E> current = new Node(head);
		//Node<E> current = aHead;
		//Node<E> after = aHead;

		while (current != null)
		{
			//Node<E> after = current.next;
			Node temp = current.next;
			//after = after.next;
			current.next = previous;
			previous = current;
			//current = after;
			current = temp;
		}
		return previous.data;
	}


	public static void main(String[] args)
	{
		LinkedList<String> linked1 = new LinkedList<String>();
		linked1.add("A");
		linked1.add("B");
		linked1.add("C");
		linked1.add("D",3);

		linked1.remove(2);

		System.out.println();
		System.out.print("{");
		for (int i = 0; i <= linked1.size(); i++)
		{
			System.out.print(linked1.get(i));
			if (i<=linked1.size()-1)
			{
				System.out.print("->");
			}
		}
		System.out.print("}\n");
		System.out.println();
		System.out.println("Got :"+linked1.get(2));
		int i=0;
		System.out.print("Reverse: ");
		while (i<linked1.size())
		{
			if (i<linked1.size()-1)
			{
				System.out.print(linked1.reverse(linked1.get(i))+"->");
			}

			else
			{
				System.out.print(linked1.reverse(linked1.get(i)));
			}

			i++;
		}
	}
}