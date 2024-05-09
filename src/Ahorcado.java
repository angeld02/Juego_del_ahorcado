import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        System.out.println("Saludos, el objetivo de este juego es adivinar las letras que\n"+
        "conforman una palabra secreta, para ello contaras con 10 intentos los \n"+
        "cuales se iran reduciendo conforme coloques letras incorrectas, pero se \n"+
        "mantendran si colocas una letra que este en la palabra a adivinar, suerte!.\n");

        Scanner teclado = new Scanner(System.in);
        String palabraSecret = "codigo";
        int maxIntentos = 10;
        int intentos = 0;
        boolean fueAdivinada = false;

        //Creamos un arreglo tipo char del mismo tamano que la cantidad de caracteres de la palabra.
        char[] coincidencias = new char[palabraSecret.length()];
        
        //Lo llenamos de rayas abajo para representar los espacios. Para llenar un char se usan comillas simples('').
        for (int i = 0; i < coincidencias.length; i++) {
            coincidencias [i] = '_';
        }
        System.out.println("La palabra "+ String.valueOf(coincidencias) +" tiene "+ coincidencias.length +" caracteres."); 
        System.out.println("Empecemos!!!");
        
        
        /*El ciclo while se mantendra ejecutando mientras le queden intentos disponibles al usuario y se cerrara 
        cuando se le terminen. Cada vez que acierte una letra no se le descontaran intentos mientras que cuando
         se equivoque si.*/

        while (!fueAdivinada && intentos < maxIntentos ) {
            System.out.println("Por favor, digite una letra: ");
            System.out.println(String.valueOf(coincidencias)); /*Este causa que se reemplace el guion bajo con la 
            letra acertada y se le muestre al usuario.*/

            char letra = Character.toLowerCase(teclado.next().charAt(0));
            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecret.length(); i++) {
                if(palabraSecret.charAt(i) == letra){
                    coincidencias[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                    System.out.print("La letra digitada" +letra+ "no se encuentra en la palabra secreta.");
                    System.out.println(" Te quedan "+(maxIntentos-intentos)+" intentos.");
                    intentos++;
                } 

            if (String.valueOf(coincidencias).equalsIgnoreCase(palabraSecret)) {
                    System.out.println("!!!Felicidades, has ganado el juego!!!");
                    System.out.println("La palabra secreta es "+String.valueOf(coincidencias)+".");
                    fueAdivinada = true;
                }

        }
            if (!fueAdivinada) {
                System.out.println("Lastima, te quedaste sin intentos.");                          
            } 
               
        }  
        
    }

