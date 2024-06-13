package juego;

public class Posicion {

    private static int y;
    private static int x;
    private int tabx;
    private int taby;
    private static Boolean salida;

    public Posicion(int tabx, int taby, int x, int y){
        this.x= x;
        this.y= y;
        salida=false;
        this.tabx = tabx;
        this.taby = taby;
    }

    public void movimiento(String mov){
         switch(mov){
            case "W":
                if(taby>y){
                    y++;
                }
                else{
                    System.out.println("Alcanzaste el limite superior del tablero");
                }             
                break;
            case "A":
                if(x >0){
                    x--;
                }else{
                    System.out.println("Alcanzaste el limite oeste del tablero");
                }
                break;
            case "D":
                if(tabx>x){
                    x++;
                }else{
                    System.out.println("Alcanzaste el limite este del tablero");
                }
                break;
            case "S":
                if(y>0){
                    y--;
                }else{
                    System.out.println("Alcanzaste el limite inferior del tablero");
                }
                break;
            case "E":
                salida=true;
                break;
            default:
                System.out.println("Movimiento no valido");
         }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Boolean getSalida(){
        return salida;
    }

    public int getTabx(){
        return tabx;
    }

    public int getTaby(){
        return taby;
    }
}
