package com.george.vending;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gogo
 */
public class ProductsCounter 
{
    int product;
    
    public ProductsCounter()
    {
        product = 10;
    }
    
    public int getCount()
    {
        return product;
    }
    
    public void setCounter(int x)
    {
        product = x;
    }
    
    public void decreaseCount()
    {
        product--;
    }
}
