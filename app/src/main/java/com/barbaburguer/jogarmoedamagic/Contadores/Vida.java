package com.barbaburguer.jogarmoedamagic.Contadores;

import android.view.View;
import android.widget.Button;

import com.barbaburguer.jogarmoedamagic.Activitys.MainActivity;
import com.barbaburguer.jogarmoedamagic.R;

public class Vida extends MainActivity {
    private int vida;
    private View botao;

    public Vida(int vidaAtual, View botaoSelecionado) {
        vida = vidaAtual;
        botao = botaoSelecionado;
    }
    public int alterando(){
        switch (botao.getId()){
            case R.id.AumentarVidaPlus:
                vida = vida+5;
                break;
            case R.id.aumentarVida:
                vida = vida+1;
                break;
            case R.id.diminuirVida:
                vida = vida-1;
                break;
            case R.id.DiminuirVidaplus:
                vida = vida-5;
                break;
                default:
                    break;
        }
        return vida;
    }

}
