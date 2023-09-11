/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.Random;

public class Grid implements Serializable{
    public Cell[][] cells = new Cell[20][20];
    static int dx[] = {1,1,1,0,0,-1,-1,-1};
    static int dy[] = {1,0,-1,1,-1,1,0,-1};
    private static int noOfBombs = 10;
    
    public Grid()
    {
        ////all cells are equal #
        for(int i = 0;i<10;i++)
        {
            for(int j = 0;j<10;j++) {
                cells[i][j] = new Cell(i, j);
                cells[i][j].setValue('#');
            }
        }
    }
        /////10 columns and rows 
    public boolean isValid(int x,int y)
    {
        return x>=0 && y >=0 && x<10 && y<10;
    }

    public Grid(int noOfBombs) { ///////to chose number of booomb
    
        this.noOfBombs = noOfBombs;
    }
        // STEP 1
        //to count bombs about cells
    public void minecnt()
    {
        int cnt ,nx,ny;
        for(int i = 0 ; i < 10 ; i++) {
            for(int j = 0 ; j < 10 ; j++) {
                cnt = 0;
                for(int k = 0;k<8;k++)
                {
                    nx = i  + dx[k];
                    ny = j + dy[k];
                    if(isValid(nx,ny) && cells[nx][ny].getValue() == 'B')
                        cnt++;
                }
                //put an appropriate number  for what surrounds the bombs
                if(cells[i][j].getValue()!='B')
                    cells[i][j].setValue((char)(cnt + '0'));
            }
        }
    }
        //STEP 2
    public void floodFill(int x,int y)
    {
        /// 
        if(cells[x][y].getValue() == 'B' || cells[x][y].isVisible() || cells[x][y].isFlag())
            return;
        ////show cell 
        cells[x][y].setVisible(true);
         /// if come across number flood Fill will be stoped .
        if(cells[x][y].getValue() > '0' && cells[x][y].getValue() <'9')
            return ;
        
        for(int i = 0;i<8;i++)
        {
            if(isValid(x + dx[i],y+dy[i]))
                floodFill(x+dx[i],y+dy[i]);
        }
    }
    ////// STEP 3 : 
    public void bombInit() {
        Random r1 = new Random();

        for(int i = 0 ; i < noOfBombs ; i++) {
            int x = r1.nextInt(10); //get random number betwwen 0 to 10
            int y = r1.nextInt(10);
            if(cells[x][y].getValue() != 'B' && !cells[x][y].isVisible())
                cells[x][y].setValue('B');
            else i--;
        }
        minecnt();
    }
    
   
    public void visibleAll()
    {
        for(int i = 0;i<10;i++)
        {
            for(int j = 0;j<10;j++)
                cells[i][j].setVisible(true);
        }
    }
    public boolean AllIsVisible(){
        int count = 0;
         for(int i = 0;i<10;i++)
        {
            for(int j = 0;j<10;j++)
                if(cells[i][j].isVisible())
                    count++;
        }
         
        if(count == 100)
           return true ;
        return false;
    }

    

    public int unCheckedCells()
    {
        int cnt = 0;
        for(int i = 0;i<10;i++)
        {

            for(int j = 0;j<10;j++)
            {
                if(!cells[i][j].isVisible())
                    cnt++;
            }
        }
        return cnt;
    }

    public void print()
    {
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        System.out.println("   --------------------------------------");
        for(int i = 0 ; i < 10 ; i++) {
            System.out.print(i +":" + "  ");
            for(int j = 0 ; j < 10 ; j++) {
                if(cells[i][j].isFlag())
                    System.out.print("P   ");
                else if(cells[i][j].isVisible())
                System.out.print(cells[i][j].getValue() + "   ");
                else {
                    System.out.print("#   ");
                }
            }
            System.out.println();
        }
    }
}
