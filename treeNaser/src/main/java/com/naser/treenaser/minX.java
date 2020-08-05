/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naser.treenaser;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author akramassi
 */

 public class minX implements Runnable 
    {
    
    private binTree tb =new binTree();
    public minX(binTree tb)
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

