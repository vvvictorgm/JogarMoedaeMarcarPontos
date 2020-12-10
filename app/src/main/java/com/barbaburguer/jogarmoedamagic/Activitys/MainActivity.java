package com.barbaburguer.jogarmoedamagic.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.barbaburguer.jogarmoedamagic.Contadores.Vida;
import com.barbaburguer.jogarmoedamagic.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView moeda,moeda2,moeda3;
    private Button manaVermelha,manaVerde,manaAzul;
    private int ativado,acertos,erros,totalVida, mana;
    private TextView nAcertos, nErros, vida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //colocar os acertos e erros e a mana a 0 toda vez que iniciar o aplicativo
        mana = 0;
        acertos=0;
        erros=0;

        //instanciar todos os elementos da tela
        nAcertos = findViewById(R.id.acertos);
        nErros = findViewById(R.id.erros);
        moeda = findViewById(R.id.Moeda);
        moeda2 = findViewById(R.id.moeda2);
        moeda3 = findViewById(R.id.moeda3);
        vida = findViewById(R.id.vida);
        manaVermelha = findViewById(R.id.manaVermelha);
        manaVerde = findViewById(R.id.manaVerde);
        manaAzul = findViewById(R.id.manaAzul);

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
    //aumenta ou diminui a mana
    public void manaAlterar (View view){
        int mana;
        switch (view.getId()){
            case R.id.manaAzul:
                mana = Integer.parseInt(manaAzul.getText().toString());
                mana = mana +1;
                manaAzul.setText(""+mana);
                break;
            case R.id.manaVerde:
                mana = Integer.parseInt(manaVerde.getText().toString());
                mana = mana +1;
                manaVerde.setText(""+mana);
                break;
            case R.id.manaVermelha:
                mana = Integer.parseInt(manaVermelha.getText().toString());
                mana = mana +1;
                manaVermelha.setText(""+mana);
                break;
            case R.id.diminuirManaAzul:
                mana = Integer.parseInt(manaAzul.getText().toString());
                mana = mana -1;
                manaAzul.setText(""+mana);
                break;
            case R.id.diminuirManaVerde:
                mana = Integer.parseInt(manaVerde.getText().toString());
                mana = mana -1;
                manaVerde.setText(""+mana);
                break;
            case R.id.diminuirManaVermelha:
                mana = Integer.parseInt(manaVermelha.getText().toString());
                mana = mana -1;
                manaVermelha.setText(""+mana);
                break;
           //caso clicar em zerar, tudo vai a 0
                default:
                    manaVerde.setText("0");
                    manaVermelha.setText("0");
                    manaAzul.setText("0");
        }

        }

        //ao clicar nos botões, aumenta vida e diminui vida, depende do botão aumenta ou diminui de 5 em 5
    public void vidaAlterada(View view){
        Vida alterarVida = new Vida(totalVida, view);
        totalVida = alterarVida.alterando();
        vida.setText(""+totalVida);
            }



}
