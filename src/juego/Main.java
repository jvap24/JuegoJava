package juego;

import javax.swing.JOptionPane;

public class Main {
   
    public static void main(String[] args) {
        Boolean check = false;
        String tab;
        int wtabX;
        int wtabY;
        String [] wtab;
        String posPlayer;
        String [] wposPlayer;
        int wposPlayerX;
        int wposPlayerY;
        String mov;

        tab = JOptionPane.showInputDialog("Mete el tamaño del tablero (x,y)");
        wtab = tab.split(",");

        System.out.println(wtab.length);
        while ((!tab.contains(",") || wtab.length !=2) || (!isInteger(wtab[0]) || !isInteger(wtab[1])) || (Integer.parseInt(wtab[0])<0 || Integer.parseInt(wtab[1])<0)){
                if(wtab.length ==2 && (isInteger(wtab[0]) && isInteger(wtab[1]))){
                    if(Integer.parseInt(wtab[0])<0 || Integer.parseInt(wtab[1])<0 ){
                        tab = JOptionPane
                        .showInputDialog("No se pueden meter numeros negativos. Vuelve a meter el tamaño del tablero (x,y)");
                        wtab = tab.split(",");
                    } 
                }else{
                    tab = JOptionPane
                        .showInputDialog("No has metido los datos correctos. Vuelve a meter el tamaño del tablero (x,y)");
                    wtab = tab.split(",");
                }
        }
        
        wtabX = Integer.parseInt(wtab[0]);
        wtabY = Integer.parseInt(wtab[1]);
        posPlayer = JOptionPane.showInputDialog("En que posición estas?(x,y)");
        wposPlayer = posPlayer.split(",");
        
        while (check == false) {
            if (wposPlayer.length != 2) {
                while (wposPlayer.length != 2) {
                    posPlayer = JOptionPane
                            .showInputDialog("Introduce los datos correctos. Vuelve a indicar la posición (x,y)");
                    wposPlayer = posPlayer.split(",");
                    wposPlayerX = Integer.parseInt(wposPlayer[0]);
                    wposPlayerY = Integer.parseInt(wposPlayer[1]);
                }
            } else if ((Integer.parseInt(wposPlayer[0]) > wtabX) || (Integer.parseInt(wposPlayer[0]) < 0)
                    || (Integer.parseInt(wposPlayer[1]) > wtabY) || (Integer.parseInt(wposPlayer[1]) < 0)) {

                    if (( Integer.parseInt(wposPlayer[0]) > wtabX) || (Integer.parseInt(wposPlayer[1]) < 0)) {
                        posPlayer = JOptionPane
                                .showInputDialog("Valor x fuera del limite ("+wtabX+"). Vuelve a indicar la posición (x,y)");
                        wposPlayer = posPlayer.split(",");
                        wposPlayerX = Integer.parseInt(wposPlayer[0]);
                        wposPlayerY = Integer.parseInt(wposPlayer[1]);

                        System.out.println(wposPlayer.length);
                    } else if ((Integer.parseInt(wposPlayer[1]) > wtabY)
                            || (Integer.parseInt(wposPlayer[1]) < 0)) {
                        posPlayer = JOptionPane
                                .showInputDialog("Valor y fuera del limite("+wtabY+"). Vuelve a indicar la posición (x,y)");
                        wposPlayer = posPlayer.split(",");
                        wposPlayerX = Integer.parseInt(wposPlayer[0]);
                        wposPlayerY = Integer.parseInt(wposPlayer[1]);
                    }
            } else {
                check = true;
            }
        }
        wposPlayerX = Integer.parseInt(wposPlayer[0]);
        wposPlayerY = Integer.parseInt(wposPlayer[1]);

        Posicion pos = new Posicion(wtabX,wtabY,wposPlayerX, wposPlayerY);
        System.out.println("El tablero es de " + pos.getTabx() + " de ancho y " + pos.getTaby() + " de alto.");
        do {
            mov = JOptionPane.showInputDialog("Por donde te quieres mover? (W,A,S,D). Pulsa E para salir. ");
            pos.movimiento(mov.toUpperCase());
            System.out.println("Tu posicion es x: " + pos.getX() + ", y: " + pos.getY());
        } while (pos.getSalida() == false);

        System.out.println("Gracias por jugar");
    }

    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}