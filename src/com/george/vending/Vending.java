package com.george.vending;

/**
 * @version modified 18/09/2012 at 15:58
 * @author Gogo
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Vending 
{ 
    static DecimalFormat df = new DecimalFormat("#####0.00");
	private static Scanner keyboard;
	private static String pound = "\u00a3";
	private static String euro = "\u20ac";
    
    public static void main(String[] args) 
    {
      keyboard = new Scanner(System.in);
      
      ProductsCounter gumPrim = new ProductsCounter();
      ProductsCounter chocoPrim = new ProductsCounter();
      ProductsCounter juicePrim = new ProductsCounter();
      ProductsCounter popcornPrim = new ProductsCounter();
      
      
      int gum = 0;
      int choco = 0;
      int juice = 0;
      int popcorn = 0;
      
      double gumTotalMoney = 0;
      double chocoTotalMoney = 0;
      double juiceTotalMoney = 0;
      double popcornTotalMoney = 0;
      
      char choice;
      
      System.out.println();
      do
      {
        System.out.println("*** VENDING MACHINE ***");
        System.out.println();
        System.out.println("[1] Get gum");
        System.out.println("[2] Get chocolate");
        System.out.println("[3] Get popcorn");
        System.out.println("[4] Get juice");
        System.out.println("[5] Display total sold so far");
        System.out.println("[6] Refill products");
        System.out.println("[7] Check what has left on shelves");
        System.out.println("[8] Quit");
        System.out.println();
        System.out.print("enter your choice : ");
        choice = keyboard.next().charAt(0);
        
        switch(choice)
        {
            case '1' : System.out.println("\nThe price of this item is " + pound + "1.45");
                       System.out.print("Please put your money : ");
                       double moneyIn = keyboard.nextDouble();
                       if (moneyIn < 1.45)
                       {
                           System.out.println("Sorry not enough money");
                       }
                       else
                       {
                        if(gumPrim.getCount() != 0)
                        {
                            System.out.println("Here's your gum");
                            gum++;
                            gumPrim.decreaseCount();
                            gumTotalMoney = gumTotalMoney + 1.45;
                            System.out.println();
                            if(moneyIn > 1.45)
                            System.out.println("Please take your " + pound +  df.format((moneyIn - 1.45)) + " change");
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Product sold out");
                            System.out.println("You'll recieve your money back\n" + pound + moneyIn);
                            System.out.println();
                        }
                       }
                        break;
            case '2' : System.out.println("\nThe price of this item is " + pound + "2.25");
                       System.out.print("Please put your money : ");
                       double moneyIn2 = keyboard.nextDouble();
                       if (moneyIn2 < 2.25)
                       {
                           System.out.println("Sorry not enough money");
                       }
                       else
                       {
                        if(chocoPrim.getCount() != 0)
                        {
                            System.out.println("Here's your chocolate");
                            choco++;
                            chocoPrim.decreaseCount();
                            chocoTotalMoney = chocoTotalMoney + 2.25;
                            System.out.println();
                            if(moneyIn2 > 2.25)
                            System.out.println("Please take your " + pound + df.format(moneyIn2 - 2.25) + " change");
                        }
                        else
                        {
                            System.out.println("Product sold out");
                            System.out.println("You'll recieve your money back\n" + pound +  moneyIn2);
                            System.out.println();
                        }
                       }
                        break;
            case '3' : System.out.println("\nThe price of this item is " + pound + "1.80");
                       System.out.print("Please put your money : ");
                       double moneyIn3 = keyboard.nextDouble();
                       if (moneyIn3 < 1.80)
                       {
                           System.out.println("Sorry not enough money");
                       }
                       else
                       {
                        if(juicePrim.getCount() != 0)
                        {
                            System.out.println("Here's your juice");
                            juice++;
                            juicePrim.decreaseCount();
                            juiceTotalMoney = juiceTotalMoney + 1.80;
                            System.out.println();
                            if(moneyIn3 > 1.80)
                            System.out.println("Please take your " + pound + df.format(moneyIn3 - 1.80) + " change");
                        }
                        else
                        {
                            System.out.println("Product sold out");
                            System.out.println("You'll recieve your money back\n" + pound + moneyIn3);
                            System.out.println();
                        }
                       }
                        break;
            case '4' : System.out.println("\nThe price of this item is " + pound + "1.20");
                       System.out.print("Please put your money : ");
                       double moneyIn4 = keyboard.nextDouble();
                       if (moneyIn4 < 1.20)
                       {
                           System.out.println("Sorry not enough money");
                       }
                       else
                       {
                        if(popcornPrim.getCount() != 0)
                        {
                            System.out.println("Here's your popcorn");
                            popcorn++;
                            popcornPrim.decreaseCount();
                            popcornTotalMoney = popcornTotalMoney + 1.20;
                            System.out.println();
                            if(moneyIn4 > 1.20)
                            System.out.println("Please take your " + pound + df.format(moneyIn4 - 1.20) + " change");
                        }
                        else
                        {
                            System.out.println("Product sold out");
                            System.out.println("You'll recieve your money back\n" + pound + moneyIn4);
                            System.out.println();
                        }
                       }
                        break;
            case '5' : System.out.println();
                        total(gum,choco,juice,popcorn,gumTotalMoney,chocoTotalMoney,
                                juiceTotalMoney, popcornTotalMoney);break;
            case '6' : refill(gumPrim,chocoPrim,juicePrim,popcornPrim);break;
            case '7' : left(gumPrim,chocoPrim,juicePrim,popcornPrim);break;
            case '8' : break;
            default : System.out.println("Choice 1 - 8 ONLY");
        }
      }while(choice != '8');
      
      System.out.println("Good Bye !!!");
    }
    
    static void total(int gumIn,int chocoIn, int juiceIn, int popcornIn,double gumTotalMoneyIn,
            double chocoTotalMoneyIn, double juiceTotalMoneyIn, double popcornTotalMoneyIn)
    {
        System.out.println(gumIn + " items of gum sold");
        System.out.println("Total amount of gums sold : "+ pound + df.format(gumTotalMoneyIn));
        System.out.println();
        System.out.println(chocoIn + " items of chocolates sold");
        System.out.println("Total amount of chocolates sold : "+ pound + df.format(chocoTotalMoneyIn));
        System.out.println();
        System.out.println(juiceIn + " items of juices sold");
        System.out.println("Total amount of juices sold : " + pound + df.format(juiceTotalMoneyIn));
        System.out.println();
        System.out.println(popcornIn + " items of popcorns sold");
        System.out.println("Total amount of popcorns sold : "+ pound + df.format(popcornTotalMoneyIn));
        System.out.println();
        System.out.println();
    }
    
    static void refill(ProductsCounter gumPrimIn, ProductsCounter chocoPrimIn,
            ProductsCounter juicePrimIn, ProductsCounter popcornPrimIn)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Please choose which product to refill:");
        System.out.println("[1] gum");
        System.out.println("[2] chocolate");
        System.out.println("[3] popcorn");
        System.out.println("[4] jiuce");
        System.out.println();
        System.out.print("enter choice : ");
        char entry = sc.next().charAt(0);
        
        switch(entry)
        {
            case '1' : 
                System.out.println();
                System.out.println("There were " + gumPrimIn.getCount() + " items left");
                System.out.println((10 - gumPrimIn.getCount()) + " were added");
                gumPrimIn.setCounter(10);break;
                case'2': 
                    System.out.println();
                System.out.println("There were " + chocoPrimIn.getCount() + " items left");
                System.out.println((10 - chocoPrimIn.getCount()) + " were added");
                chocoPrimIn.setCounter(10);break;
                    case'3': 
                        System.out.println();
                System.out.println("There were " + juicePrimIn.getCount() + " items left");
                System.out.println((10 - juicePrimIn.getCount()) + " were added");
                        juicePrimIn.setCounter(10);break;
                        case'4': 
                            System.out.println();
                System.out.println("There were " + popcornPrimIn.getCount() + " items left");
                System.out.println((10 - popcornPrimIn.getCount()) + " were added");
                popcornPrimIn.setCounter(10);break;
        }
    }
    
    static void left(ProductsCounter gumPrimIn, ProductsCounter chocoPrimIn,
            ProductsCounter juicePrimIn, ProductsCounter popcornPrimIn)
    {
        System.out.println();
        System.out.println(gumPrimIn.getCount() + " items of gum left");
        System.out.println(chocoPrimIn.getCount() + " items of chocolate left");
        System.out.println(juicePrimIn.getCount() + " items of juice left");
        System.out.println(popcornPrimIn.getCount() + " items of popcorn left");
        System.out.println();
    }
}
