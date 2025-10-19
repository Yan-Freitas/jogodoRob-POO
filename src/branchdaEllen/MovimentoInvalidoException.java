package branchdaEllen;

public class MovimentoInvalidoException extends Exception{
    public MovimentoInvalidoException(){
        super("Movimento Inválido! Tente outro movimento");
    }
}