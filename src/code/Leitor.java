import java.io.FileReader;
import java.io.BufferedReader;

public class Leitor
{
	private int numJogadores;
    public int numPosicoes;
    public int numJogadas;

    public void Reader() throws Exception
    {
        BufferedReader entradatabuleiro = new BufferedReader(new FileReader("../IOFiles/tabuleiro.txt"));

        String line = entradatabuleiro.readLine();
        String[] token = line.split(";");
        numPosicoes = Integer.parseInt(token[0]);

        Tabuleiro[] tabuleiro = new Tabuleiro[numPosicoes+1];
        Imovel[] imovel = new Imovel[numPosicoes+1];

        for(int i=1; i <= numPosicoes; i++)
        {
            line = entradatabuleiro.readLine();
            token = line.split(";");

            if("3".equals(token[2]))
            {
                tabuleiro[Integer.parseInt(token[1])] = new Tabuleiro();
                imovel[Integer.parseInt(token[1])] = new Imovel();

                tabuleiro[Integer.parseInt(token[1])].criaPosicao(Integer.parseInt(token[2]));
                imovel[Integer.parseInt(token[1])].criaImovel((Integer.parseInt(token[3])), Double.parseDouble(token[4]), Double.parseDouble(token[5]));
            }

            else
            {
                tabuleiro[Integer.parseInt(token[1])] = new Tabuleiro();

                tabuleiro[Integer.parseInt(token[1])].criaPosicao(Integer.parseInt(token[2]));
            }
        }

        entradatabuleiro.close();

        BufferedReader jogadas = new BufferedReader(new FileReader("../IOFiles/jogadas.txt"));

        line = jogadas.readLine();
        token = line.split("%");

        numJogadas = Integer.parseInt(token[0]);
        numJogadores = Integer.parseInt(token[1]);
        double valorInicial = Double.parseDouble(token[2]);

        Jogador[] jogador = new Jogador[numJogadores+1];
        for (int i=1; i <= numJogadores ; i++)
            jogador[i] = new Jogador(i, valorInicial);

        Jogada[] jogada = new Jogada[numJogadas];
        for(int i=1; i <= numJogadas; i++)
        {
            line = jogadas.readLine();
            token = line.split(";");

            if(!("DUMP".equals(line)))
            {
                jogada[i] = new Jogada();
                jogada[i].criaJogada(Integer.parseInt(token[0]), Integer.parseInt(token[1]) ,Integer.parseInt(token[2]));
            }
        }

        jogadas.close();

        JogaJogo jogajogo = new JogaJogo();
        JogaJogo.jogaJogo(tabuleiro, imovel, jogador, jogada, numJogadas, numJogadores, numPosicoes);
    }
}
