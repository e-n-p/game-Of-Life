package gameoflife;

import java.util.Arrays;

/**
 *
 * @author nick
 */
public class Board {
    
    int column, row;
    int[][] array;
    
    public Board(int w, int h){
        this.row = w;
        this.column = h;
    }
    void generate(){
        this.array =new int[row][column];   
        for(int[] row:this.array){
            Arrays.fill(row, 0);
        }
    }    
    void generate(int[][] arr){
        this.array = arr.clone();        
    }    
    void setColumn(int in){
        this.column = in;
    }
    void setRow(int in){
        this.row = in;
    }
    void print(){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                
                System.out.print(this.array[i][j]);               
            }
            System.out.println();
        }
    }
    int[][] duplicate(){
        //int[][] arr = this.array.clone();  
        int[][] arr = new int[row][column];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                arr[i][j] = this.array[i][j];
            }
        }
        return arr;      
    }
    void overwrite(int[][] given){
        this.array = given.clone();
    }
    
}
