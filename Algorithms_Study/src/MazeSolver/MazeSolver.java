package MazeSolver;

import java.util.Stack;

public class MazeSolver {
	
	MazeSolver(){
		
	}
	
	private class Coordinates {
		int r;
		int c;
		Coordinates(int r, int c){
			this.r = r; this.c = c;
			}
	}

	
	public void SearchPath(int[][] Maze, int row, int col, Stack<Coordinates> path, Stack<Move> lastMoves){
		if( row == Maze.length && col == Maze[0].length){
			//last row and col reached , soln found
			return;
		}
		else{
			//go down and check
			if(Maze[row+1][col] == 1){
				path.push(new MazeSolver.Coordinates(row+1,col));
				lastMoves.push(Move.GO_DOWN);
				SearchPath(Maze,row+1,col,path,lastMoves);
			}
			//go right and check
			else if(Maze[row][col+1] == 1){
				path.push(new MazeSolver.Coordinates(row,col+1));
				lastMoves.push(Move.GO_RIGHT);
				SearchPath(Maze,row,col+1,path,lastMoves);
			}
			//both right and down are dead. So mark this as dead too and go back [opposite to last move]
			else{
				Maze[row][col] = 0;
				Move m = lastMoves.pop(); // take out the last move and check
				path.pop(); // remove the last coordinate added to the path
				if(m == Move.GO_DOWN){
					//go up and search again
					SearchPath(Maze,row - 1,col,path,lastMoves);
				}
				else if(m == Move.GO_RIGHT){
					//go left
					SearchPath(Maze,row,col + 1,path,lastMoves);
				}
				
			}
		}
		
	}

}
