import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.*;




public class JunitTest {
    @Test
    public void whenCreated() { 

        ShoppingCart shoppingCart = new ShoppingCart();
        org.junit.Assert.assertTrue (shoppingCart.getItemCount()==0);
    
    }

    @Test
    public void whenEmpty(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Product("product 1", 10));
        shoppingCart.addItem(new Product("product 2", 30));
       
        shoppingCart.empty();
        org.junit.Assert.assertTrue (shoppingCart.getItemCount()==0);
    }

    @Test
    public void increaseIncrement(){ 

        ShoppingCart shoppingCart = new ShoppingCart();
        int count1 = shoppingCart.getItemCount();
        shoppingCart.addItem(new Product("product 1", 10));
        shoppingCart.addItem(new Product("product 2", 20));

        int count2 = shoppingCart.getItemCount();
        org.junit.Assert.assertTrue (count1 < count2);
    }

    @Test
    public void decreaseIncrement(){ 
        ShoppingCart shoppingCart = new ShoppingCart();
        int count1 = shoppingCart.getItemCount();
        shoppingCart.addItem(new Product("product 1", 10));
        shoppingCart.addItem(new Product("product 2", 20));
        int count2 = shoppingCart.getItemCount();
        org.junit.Assert.assertTrue (count1 > count2);


        
    }

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(JunitTest.class);

        for (Failure failure : result.getFailures()){
           System.out.println(failure.toString());}

        System.out.println("total cases:" +result.getRunCount());
        System.out.println("failures:" +result.getFailures().size());

    }


}
