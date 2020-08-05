/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naser.treenaser;

import static com.naser.treenaser.main.addToTree;
import static com.naser.treenaser.main.list;
import java.util.Random;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akramassi
 */

class add implements Runnable 
    {
    
    private binTree tb =new binTree();
    public add(binTree tb)
    {
        super();
        
        this.tb=tb;
        
    }
    @Override
        public void run() {
            int i=0;
          while ( true )
          {
                addToTree(tb);
                i++;
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
             }
          }
        }
    }
class delete implements Runnable 
    {
    
    private binTree tb =new binTree();
    public delete(binTree tb)
    {
        super();
        this.tb=tb;
        
    }
    @Override
        public void run() {
            int i=0;
          while ( true )
          {
               try {
                 Thread.sleep(1500);
             } catch (InterruptedException ex) {
                 Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
             }
                Random rand = new Random();
                int size=tb.getN();
                if (size>0)
                {
                    int index =rand.nextInt(size);
                    if(index>=0&&index<size)
                    {
                        synchronized(tb)
                        {
                            
                            tb.deleteKey(list.remove(index));
                            tb.setN(tb.getN()-1);
                           
                        }
                    }
                    
                }
                i++;
               
                
          }
        }
    }
class display implements Runnable 
    {
    
    private binTree tb =new binTree();
    public display(binTree tb)
    {
        super();
        
        this.tb=tb;
        
    }
    @Override
        public void run() {
            int i=0;
          while ( true )
          {
              
              synchronized(tb)
              {
                  System.out.print(tb.getN()+") in order");
                  tb.inorder();
                  System.out.println("\n");
                  i++;
              }
                
                
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
             }
                
          }
        }
    }
class min implements Runnable 
    {
    
    private binTree tb =new binTree();
    public min(binTree tb)
    {
        super();
        
        this.tb=tb;
        
    }
    @Override
        public void run() {
          while ( true )
          {
              if (tb.getN()>0)
              {
                    synchronized(tb)
                    {
                        System.out.println("the min value is : "+tb.minValue());
                    }
              }
                
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
             }
                
          }
        }
    }
class max implements Runnable 
    {
    
    private binTree tb =new binTree();
    public max(binTree tb)
    {
        super();
        
        this.tb=tb;
        
    }
    @Override
        public void run() {
          while ( true )
          {
              if (tb.getN()>0)
              {
                    synchronized(tb)
                    {
                        System.out.println("the max value is : "+tb.maxValue());
                    }
              }
                
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
             }
                
          }
        }
    }
public class main {
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void addToTree(binTree tb)
    {
        Random rand = new Random();
        synchronized(tb)
        {
            int temp =rand.nextInt(400);
            tb.insert(temp);
            list.add(temp);

        }
    }
    
    
//    public static void main(String[] args) {
//        binTree tb= new binTree();           
//        add ma = new add(tb);
//        display ms = new display(tb);
//        delete mx = new delete(tb);
//        min mv=new min(tb);
//        max mq=new max(tb);
//        new Thread(ma).start();
//        new Thread(ms).start();
//        new Thread(mx).start();
//       new Thread(mv).start();
//       new Thread(mq).start();
//       
//
//
//
//
//
//
//
//
//
//    }
}
