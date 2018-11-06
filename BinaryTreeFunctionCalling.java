package BinaryTree;

import java.util.Scanner ;
import java.util.Random ;

public class BinaryTreeFunctionCalling
{
	BinaryTreeFunctionCalling()
	{
		Scanner sc = new Scanner( System.in ) ;
		Random rn = new Random() ;
		BinaryTreeFunctions btf = new BinaryTreeFunctions() ;
		
		while(true)
		{
			System.out.println("1.Insert, 2.Display, 3.Number of Nodes, 4.No. of Leaf Nodes, 5.Maximum Number, 6.Find Path, 7.Level, 8.Exit") ;
			int op = sc.nextInt() ;
			
			if( op == 1)
			{
				System.out.print("Enter how many numbers :- ");
				int opinsert = sc.nextInt() ;
				
				for( int i = 0 ; i < opinsert ; i++)
					btf.insert( ( rn.nextInt(50) + 1) ) ;
			}
			else if( op == 2)
				btf.print() ;
			
			else if( op == 3)
				btf.NumberOfNodes() ;
			
			else if( op == 4)
				btf.NumberofLeafNodes() ;
			
			else if( op == 5)
				btf.MaximumNumber() ;
			
			else if( op == 6)
			{
				System.out.print("Enter Data :- ") ;
				int data = sc.nextInt() ;
				
				if( data == 0)
					System.out.println(data+" is not availbale in Binary Tree");
				else
					btf.FindPath( data ) ;
			}
			else if( op == 7)
				System.out.println("Level :- "+btf.Level() ) ;
			
			else if( op == 8)
				break ;
			
			else
				System.out.println("Wrong Input, Please Enter Correct Input") ;
		}
	}
}
