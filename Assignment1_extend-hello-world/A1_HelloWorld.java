public class A1_HelloWorld {
    private String greeting = "Hello, World!";
    public void greet()
    
    {
    System.out.println(greeting); 
    }

    // Setter method to update the greeting message
    public void setGreeting (String newGreeting)
    {
        this.greeting = newGreeting;
    }
    
    public static void main (String args[])
    {
    A1_HelloWorld helloworld;
    helloworld = new A1_HelloWorld ();
    helloworld.greet () ;

    helloworld = new A1_HelloWorld ();
    // Update the greeting message using the setter
    helloworld.setGreeting("HELLO NEW WORLD");
    helloworld.greet () ;
    } 
}