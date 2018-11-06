package BinaryTree;

import java.util.ArrayList ;

public class BinaryTreeFunctions
{
	ArrayList<Integer> binaryarray = new ArrayList<Integer>(0) ;
	
	BinaryTreeNode root ;
	int count = 0 ;
	int a[] ;
	
	void insert( int data )
	{
		if( root == null)
		{
			root = new BinaryTreeNode() ;
			root.data = data ;
			binaryarray.add(data) ;
		}
		else
		{
			BinaryTreeQueue btq = new BinaryTreeQueue() ;
			btq.EnQueue( root ) ;
			binaryarray.add(data) ;
			
			while( btq.IsQueueEmpty() == false)
			{
				BinaryTreeNode temp = btq.DeQueue() ;
				
				if( temp.LeftChild == null)
				{
					temp.LeftChild = new BinaryTreeNode() ;
					temp.LeftChild.data = data ;
					break ;
				}
				else
					btq.EnQueue(temp.LeftChild) ;
				
				if( temp.RightChild == null)
				{
					temp.RightChild = new BinaryTreeNode() ;
					temp.RightChild.data = data ;
					break ;
				}
				else
					btq.EnQueue(temp.RightChild) ;
			}
		}
	}
	void print()
	{
		for( int i = 0 ; i < binaryarray.size() ; i++)
			System.out.print( binaryarray.get(i) +" ") ;
		
		System.out.println();
	}
	void CalculateNumberOfNodes( BinaryTreeNode root )
	{
		if(root!= null)
			count++ ;
		
		if( root.LeftChild != null )
			CalculateNumberOfNodes( root.LeftChild) ;
		
		if( root.RightChild != null )
			CalculateNumberOfNodes( root.RightChild) ;
	}
	void NumberOfNodes( )
	{
		CalculateNumberOfNodes( root ) ;
		System.out.println("No. of Nodes :- "+count);
		count = 0 ;
	}
	void CalculateNumberOfLeafNodes( BinaryTreeNode root )
	{
		if( root.LeftChild != null && root.RightChild != null)
			count++ ;
		
		if( root.LeftChild != null )
			CalculateNumberOfLeafNodes( root.LeftChild) ;
		
		if( root.RightChild != null )
			CalculateNumberOfLeafNodes( root.RightChild) ;
	}
	void NumberofLeafNodes()
	{
		CalculateNumberOfLeafNodes( root ) ;
		System.out.println("No. of Nodes :- "+( count+1 ) ) ;
		count = 0 ;
	}
	void CalculateMaximumNumber( BinaryTreeNode root )
	{
		if( root != null)
		{
			if(root.data > count)
				count = root.data ;
			
			if( root.LeftChild != null )
				CalculateMaximumNumber( root.LeftChild) ;
			
			if( root.RightChild != null )
				CalculateMaximumNumber( root.RightChild) ;
		}
	}
	void MaximumNumber()
	{
		count = Integer.MIN_VALUE ;
		
		CalculateMaximumNumber( root ) ;
		
		System.out.println("Maximum Number :- "+count);
		count = 0 ;
	}
	void CalculateFindPath(int data, BinaryTreeNode node )
	{
		BinaryTreeQueue btq = new BinaryTreeQueue() ;
		btq.EnQueue( root ) ;
		
		while( btq.IsQueueEmpty() == false)
		{
			BinaryTreeNode temp = btq.DeQueue() ;
			
			System.out.print(temp.data +" ") ;
			if( temp.LeftChild != null)
				btq.EnQueue(temp.LeftChild) ;
			
			if( temp.RightChild != null)
				btq.EnQueue(temp.RightChild) ;
		}
	}
	int Level()
	{
		int i, size = binaryarray.size() ;
		
		for( i = 0 ; i < size ; i++)
		{
			if( ( Math.pow( 2, i ) ) - 1 >= size &&  ( Math.pow( 2, i-1 ) ) - 1  <= size )
				break ;
		}
		return i ;
	}
	void ArrayFixing()
	{
		a = new int[ (int) (Math.pow( 2, Level() ) - 1) ] ;
		
		for( int i = 0 ; i<binaryarray.size() ; i++)
			a[i] = binaryarray.get(i) ;
		
	}
	void FindPath( int data )
	{
		ArrayList<Integer> indexes = new ArrayList<Integer>(0) ;
		
		int i ;
		boolean flag = false ;
		ArrayFixing() ;
		
		for( i = 0 ; i<a.length ; i++)
		{
			if( data == a[i])
			{
				flag = true ;
				indexes.add(i) ;
			}
		}
		if( flag == true)
		{
			for( int j = 0 ; j <indexes.size() ; j++)
			{
				int index = indexes.get(j), parentindex = Integer.MAX_VALUE ;
				
				String temppath = "" ;
				
				while( parentindex != 0 )
				{
					if( index % 2 == 0)
					{
						temppath = temppath + "Right, " ;
						parentindex = ( index - 2)/2 ;
					}
					else
					{
						temppath = temppath + "Left, " ;
						parentindex = ( index - 1)/2 ;
					}
					index = parentindex ; 
				}
				String path[] = temppath.split(", ") ;
				System.out.print( (j+1)+" Path :- ") ;
				System.out.print("Root -> ");
				for( i = path.length - 1  ; i >= 0 ; i--)
					System.out.print(path[i] +" -> ");
				
				System.out.println();
			}
		}
		else
			System.out.println(data+" is not available in Binary Tree");
	}
}
