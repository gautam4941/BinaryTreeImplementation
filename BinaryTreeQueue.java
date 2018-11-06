package BinaryTree;

public class BinaryTreeQueue
{
	QueueNode front, rear ;
	
	boolean IsQueueEmpty()
	{
		if( front == null && rear == null )
			return true ;
		else
			return false ;
	}
	
	void EnQueue( BinaryTreeNode node )
	{
		if( IsQueueEmpty() == true)
		{
			front = new QueueNode() ;
			
			front.element = node ;
			rear = front ;
		}
		else
		{
			QueueNode temp = new QueueNode() ;
			temp.element = node ;
			
			rear.next = temp ;
			rear = temp ;
		}
	}
	
	BinaryTreeNode DeQueue()
	{
		if( IsQueueEmpty() == false)
		{
			BinaryTreeNode temp = front.element ;
			
			if(front.next == null )
			{
				front = null ;
				rear = null ;
			}
			else
			{
				QueueNode ptr = front ;
				front = front.next ;
				ptr = null ;
			}
			return temp ;
		}
		else
		{
			System.out.print("No Element in Binary Tree");
			return null ;
		}
	}
}
