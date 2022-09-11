package tictactoe;

public class YesNoDialog {

    public char read() {
        char answer;
        do {
            answer = new IO().readChar("Desea continuar (s/n): ");
        } while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
        return answer;
    }
}
