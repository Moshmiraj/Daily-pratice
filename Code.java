public class Code{
    static int function( int x){
        return -x * x+ 6 * x;
    }
    public static void main(String[] args) {
        int current = 0;
        int next;

        System.out.println("Starting at x = " + current);

        while (true) { 
            next = current + 1;
 
            if( next > 6)
            break;

            if( function(next) > function(current)) {
                current = next;
                System.out.println("Moving to x = " +current);
            } else {
                break ;
            }

        }
        System.out.println("\nFinal Solution:");
        System.out.println("Maximum value at x = " +current);
        System.out.println("Maximum f(x) = " +function(current));
    
    
    }
    }
