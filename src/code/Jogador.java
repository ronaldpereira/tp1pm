public class Jogador
{
    private int id;
  	private double total;
  	private double paidRent = 0;
  	private double receivedRent = 0;
  	private int buys = 0;
    private int turns = 0;
  	private int passedturns = 0;
    private int position = 0;
    private boolean is_playing = true;

    Jogador(int id, double total)
    {
        this.id = id;
        this.total = total;
    }
}