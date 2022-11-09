package ochoreinas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class OchoReinas {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));     
    static int tamaño;
    public static void main(String[] args) throws IOException {  
        tamaño = 8; //se le da un tamaño al tablero, típicamente un tablero de ajedrez es de 8x8
        crearTablero(tamaño);
    }    
    public static void imprimirTablero(int[][]tablero){
        for(int row = 0; row < tamaño; row++){
            for(int col = 0; col < tamaño; col++){
                System.out.print(" " + tablero[row][col] + " ");
            }
            System.out.println();
        }
    
    }
    
    public static void crearTablero(int n){
        int [][] tablero = new int[n][n];
        
        for(int row = 0; row < tamaño; row++){
            for(int col = 0; col < tamaño; col++){
                tablero[row][col] = 0;
            }
        }
        
        if(posicionar(tablero, 0) == false){
            System.out.println("No existe solución");
        }else{
            imprimirTablero(tablero);
        }
    }
    
    public static boolean posicionar(int [][] tablero, int columna){
        if(tamaño == columna){
            return true;
        }
        
       for(int row = 0; row < tamaño; row++){
            if(NoBajoAtaque(row, columna, tablero)){
                tablero[row][columna] = 1;
                
                if(posicionar(tablero, columna + 1) == true){
                    return true;
                }
                
                tablero[row][columna] = 0;
            }
                
       }
        return false;
    }
    
    public static boolean NoBajoAtaque(int rowRevisar, int colRevisar, int[][]tablero){
        int i, j;
       
       //Revisar fila elementos a la havia el lado o hacia arruba o abajo
       for(i = 0; i < colRevisar; i++)
           if(tablero[rowRevisar][i] == 1)
               return false;
       
       //Revisar diagonal hacia arriba izquierda
       for(i = rowRevisar, j = colRevisar; i >= 0 && j >= 0; i--, j--){
           if(tablero[i][j] == 1)
               return false;
       }
       
       //Revisar diagonal hacia abajo derecha1|
       for(i = rowRevisar, j = colRevisar; j >= 0 && i < tamaño; i++, j--){
           if(tablero[i][j] == 1)
               return false;
       }
       
       return true;
    }
    
}
