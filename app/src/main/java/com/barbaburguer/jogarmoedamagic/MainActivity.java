package com.barbaburguer.jogarmoedamagic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {
    private ImageView moeda,moeda2,moeda3;
    private Button manaVermelha,manaVerde,manaAzul,aumentaVida,diminuirVida;
    private int ativado,acertos,erros,totalVida;
    private TextView nAcertos, nErros, vida;
    public Handler handler = new Handler();
    public Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //colocar os acertos e erros a 0 toda vez que iniciar o aplicativo
        acertos=0;
        erros=0;
        //instanciar todos os elementos da tela
        nAcertos = findViewById(R.id.acertos);
        nErros = findViewById(R.id.erros);
        moeda = findViewById(R.id.Moeda);
        moeda2 = findViewById(R.id.moeda2);
        moeda3 = findViewById(R.id.moeda3);
        manaAzul = findViewById(R.id.manaAzul);
        manaVerde = findViewById(R.id.manaVerde);
        manaVermelha = findViewById(R.id.manaVermelha);
        vida = findViewById(R.id.vida);
        aumentaVida = findViewById(R.id.aumentarVida);
        //começar com as moedas extras invisveis
        moeda2.setVisibility(View.INVISIBLE);
        moeda3.setVisibility(View.INVISIBLE);
        //começar com o kerk não está ativado
        ativado = 0;
        //começar a vida
        totalVida = 40;


    }

    //irá gerar um numero aleatório entre 0 e 1, dependendo do resultado muda a imagem da moeda
    public void jogarMoeda(View view){
        int rolagem,rolagem2;
        //Se o krark tiver ativo para o segundo if
        if (ativado != 1) {
            //gera um numero aleatório de 0 a 1
            rolagem = new Random().nextInt(2);
            //se rolar par conta como acerto
            if (rolagem == 1) {
                moeda.setImageResource(R.drawable.moeda1);
                erros = erros+1;
                nErros.setText(""+erros);
            } else {
                //se rolar impar conta como erro
                moeda.setImageResource(R.drawable.moeda2att);
                acertos = acertos+1;
                nAcertos.setText(""+acertos);
            }
        }else{
            //gera um numero aleatorio para cada um dos dados
            rolagem = new Random().nextInt(2);
            rolagem2 = new Random().nextInt(2);
            if (rolagem == 1) {
                moeda2.setImageResource(R.drawable.moeda1);
            } else {
                moeda2.setImageResource(R.drawable.moeda2att);
            }
            if (rolagem2 == 1) {
                moeda3.setImageResource(R.drawable.moeda1);
            } else {
                moeda3.setImageResource(R.drawable.moeda2att);
            }
            if(rolagem == 0 || rolagem2 == 0){
                acertos = acertos+1;
                nAcertos.setText(""+acertos);
            }else{
                erros = erros+1;
                nErros.setText(""+erros);
            }
        }
    }
    //caso clicar na moeda Krark, irá sumir com a moeda do meio, e duas novas aparecerão,
    // caso clicado novamente, irá sumir as duas e voltar a do meio
    public void ativarKrark(View view){
        if(ativado == 0 ) {
            ativado = 1;
            moeda.setVisibility(View.INVISIBLE);
            moeda2.setVisibility(View.VISIBLE);
            moeda3.setVisibility(View.VISIBLE);
        }else{
            ativado = 0;
            moeda.setVisibility(View.VISIBLE);
            moeda2.setVisibility(View.INVISIBLE);
            moeda3.setVisibility(View.INVISIBLE);
        }

    }
    //se clicar no botão, vai subir a mana verde
    //se clicar no botão, vai descer a mana verde
    //se clicar no botão, vai subir a mana vermelha
    //se clicar no botão, vai descer a mana vermelha
    //se clicar no botão, vai subir a mana azul
    //se clicar no botão, vai descer a mana azul
    public void subirManaVerde(View view){
        int mana = Integer.parseInt((String) manaVerde.getText());
        mana = mana+1;
        manaVerde.setText(""+mana);
    }
    public void descerManaVerde(View view){
        int mana = Integer.parseInt((String) manaVerde.getText());
        mana = mana-1;
        manaVerde.setText(""+mana);
    }

    public void subirManaVermelha(View view){
        int mana = Integer.parseInt((String) manaVermelha.getText());
        mana = mana+1;
        manaVermelha.setText(""+mana);
    }
    public void descerManaVermelha(View view){
        int mana = Integer.parseInt((String) manaVermelha.getText());
        mana = mana-1;
        manaVermelha.setText(""+mana);
    }

    public void subirManaAzul(View view){
        int mana = Integer.parseInt((String) manaAzul.getText());
        mana = mana+1;
        manaAzul.setText(""+mana);
    }
    public void descerManaAzul(View view){
        int mana = Integer.parseInt((String) manaAzul.getText());
        mana = mana-1;
        manaAzul.setText(""+mana);
    }

    //zera todas as manas para zero
    public void zerar (View view){
        manaAzul.setText(""+0);
        manaVermelha.setText(""+0);
        manaVerde.setText(""+0);
    }

    //ao clicar nos botões, aumenta vida e diminui vida, depende do botão aumenta ou diminui de 5 em 5
    public void aumentarVida(View view){
        totalVida = totalVida+1;
        vida.setText(""+totalVida);
    }
    public void aumentarVidaLong() {
        totalVida = totalVida+1;
        vida.setText(""+totalVida);
    }

    public void aumentarVida2(View view){
        totalVida = totalVida+5;
        vida.setText(""+totalVida);
    }
    public void diminuirVida(View view){
        totalVida = totalVida-1;
        vida.setText(""+totalVida);
    }
    public void diminuirVida2(View view){
        totalVida = totalVida-5;
        vida.setText(""+totalVida);
    }


}
