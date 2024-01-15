/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Rishu Raj Singh
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Rishu Raj Singh
 */
 public class NewClass extends JFrame{
        
        private final int [][] maze1 = {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                                        {1,0,1,0,1,0,1,0,1,0,1,0,1},
                                        {1,0,1,0,0,0,1,0,1,1,1,0,1},
                                        {1,0,1,1,1,1,1,0,0,0,0,0,1},
                                        {1,0,0,1,0,0,0,0,1,1,1,0,1},
                                        {1,0,1,0,1,1,1,0,1,0,0,0,1},
                                        {1,0,1,0,1,0,0,0,1,1,1,0,1},
                                        {1,0,1,0,1,1,1,0,1,0,1,0,1},
                                        {1,0,0,0,0,0,0,0,0,0,1,9,1},
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        };
        public List<Integer> path = new ArrayList<>();
        
        public NewClass(){
            setTitle("Maze Solver");
            setSize(640,480);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            searchpath(maze1,1,1,path);
            
        }
        @Override
        public void paint(Graphics g){
            
                g.translate(50,50);
                
                for(int i = 0; i<maze1.length; i++){
                        for(int j = 0; j<maze1[0].length; j++){
                            Color color;
                            switch (maze1[i][j]) {
                                case 1: color = Color.BLACK;
                                    break;
                                case 9: color =  Color.GREEN;
                                    break;
                                default: color = Color.WHITE;
                                       break;
                            }
                            g.setColor(color);
                            g.fillRect(30*j, 30*i,30, 30);
                            g.setColor(Color.red);
                            g.drawRect(30*j, 30*i,30, 30);
                        }
                }
                for(int i = 0; i<path.size(); i = i+2){
                    int pathx = path.get(i);
                    int pathy = path.get(i+1);
                    
                    System.out.println(pathx);
                    System.out.println(pathy);
              
                    
                    g.setColor(Color.blue);
                    g.fillRect(30*pathx, 30*pathy,20,30);
                    
                }
        }

    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
     public static boolean searchpath(int [][] maze, int x , int y, List<Integer> path){
            if(maze[y][x]==9){
                path.add(x);
                path.add(y);
                return true;
            }
            if(maze[y][x]==0){
                maze[y][x] = 2;
                int dx = -1;
                int dy = 0;
                if(searchpath(maze,x+dx,y+dy,path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
                dx = 1;
                dy = 0;
                if(searchpath(maze,x+dx,y+dy,path)){
                     path.add(x);
                     path.add(y);
                    return true;
                }
                dx = 0;
                dy = -1;
                if(searchpath(maze,x+dx,y+dy,path)){
                     path.add(x);
                    path.add(y);
                    return true;
                }
                dx = 0;
                dy = 1;
                if(searchpath(maze,x+dx,y+dy,path)){
                     path.add(x);
                    path.add(y);
                    return true;
                }
            }   
            return false;
        }
}
