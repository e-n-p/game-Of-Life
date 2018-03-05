package gameoflife;
import java.util.Random;

public class GameOfLife {
    public static void main(String[] args) {
        int row = 8,column =8,score;
        Board table = new Board(row,column);
        table.generate();
        seedBoard(50 ,table);
        //table.overwrite(preset());
        table.print();
        System.out.println("\n ^^State of board from the seed^^ \n");
        //1 loop 1 frame of game
        for(int i=0;i<10;i++){
            int[][] swap = table.duplicate();
            for(int j=0;j<row;j++){
                for(int k=0;k<column;k++){
                    score = 0;
                    if((j == 0 && k == 0) || (j == 0 && k== column -1) || (j == row -1 && k == column-1) || (j == row -1 && k == 0) ){
                        if(j == 0 && k == 0){
                            score = table.array[j][k+1] + table.array[j+1][k] + table.array[j+1][k+1];
                        }else if(j == 0 && k== column -1){
                            score = table.array[j][k-1] + table.array[j+1][k-1] + table.array[j+1][k];
                        }else if(j == row -1 && k == column-1){
                            score = table.array[j][k-1] + table.array[j-1][k-1] + table.array[j-1][k];
                        }else{
                            score = table.array[j-1][k] + table.array[j-1][k+1] + table.array[j][k+1];
                        }
                    }else{
                        if(j == 0){
                            //j==0
                            score = table.array[j][k-1] + table.array[j][k+1] + table.array[j+1][k-1] + table.array[j+1][k] + table.array[j+1][k+1];
                        }else if(k == 0){
                            //k==0
                            score = table.array[j-1][k] + table.array[j-1][k+1] + table.array[j][k+1] + table.array[j+1][k] + table.array[j+1][k+1];
                        }else if(j == row-1){
                            //j==row-1 - bottom row
                            score = table.array[j-1][k-1] + table.array[j-1][k] + table.array[j-1][k+1] + table.array[j][k-1] + table.array[j][k+1];
                        }else if(k == column-1){
                            //k==column-1 - far right column
                            score = table.array[j-1][k-1] + table.array[j-1][k] + table.array[j][k-1] + table.array[j+1][k-1] + table.array[j+1][k];
                        }else{
                            score = table.array[j-1][k-1] + table.array[j-1][k] + table.array[j-1][k+1] + table.array[j][k-1] + table.array[j][k+1] + table.array[j+1][k-1] + table.array[j+1][k] + table.array[j+1][k+1];
                        }
                    }
                    if(score > 0 || table.array[j][k] == 1){   swap[j][k] = affectLife(score, table.array[j][k]); }
                }
            }
            //print(column, row, swap);
            table.overwrite(swap);
            table.print();
            System.out.println("\n--State of board after "+ i +" turns--\n");
        }
    }
    public static int affectLife(int score, int status){
        if(status == 1){
            if(score < 2 || score > 3){
                return 0;
            }else{
                return 1;
            }
        }
        if(status == 0){
            if(score == 3){
                return 1;
            }
        }
        return 0;
    }
    public static void seedBoard(int turns, Board table){
        Random rand = new Random();
        while(turns >1){
            int n = rand.nextInt(2);
            int x = rand.nextInt(table.row);
            int y = rand.nextInt(table.column);
            table.array[x][y] = n;
            turns--;
        }
    }
    public static void print(int width, int height, int[][] arr){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                System.out.print(arr[i][j]);               
            }
            System.out.println();
        }
    }
    public static int[][] preset(){
        int[][] arr = new int[][]{
            {0,0,0,1,0,0},
            {0,1,0,1,0,0},
            {0,0,0,0,1,0},
            {0,1,0,0,1,1},
            {1,0,1,0,1,1}};
        return arr;
    }
}