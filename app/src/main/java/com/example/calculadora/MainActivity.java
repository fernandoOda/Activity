package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String primeironumero = "";
    private String segundonumero = "";
    private String operacao = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.tv_display);
    }

    public void onclickbotao0(View v) {
        atualizarnumerodigitado("0");
        atualizarDisplay("0");
    }

    public void onclickbotao1(View v) {
        atualizarnumerodigitado("1");
        atualizarDisplay("1");
    }

    public void onclickbotao2(View v) {
        atualizarnumerodigitado("2");
        atualizarDisplay("2");
    }

    public void onclickbotao3(View v) {
        atualizarnumerodigitado("3");
        atualizarDisplay("3");
    }

    public void onclickbotao4(View v) {
        atualizarnumerodigitado("4");
        atualizarDisplay("4");
    }

    public void onclickbotao5(View v) {
        atualizarnumerodigitado("5");
        atualizarDisplay("5");
    }

    public void onclickbotao6(View v) {
        atualizarnumerodigitado("6");
        atualizarDisplay("6");
    }

    public void onclickbotao7(View v) {
        atualizarnumerodigitado("7");
        atualizarDisplay("7");
    }

    public void onclickbotao8(View v) {
        atualizarnumerodigitado("8");
        atualizarDisplay("8");
    }

    public void onclickbotao9(View v) {
        atualizarnumerodigitado("9");
        atualizarDisplay("9");
    }

    public void onclickadicao(View v) {
        if (!primeironumero.isEmpty()) {
            operacao = "+";
            atualizarDisplay("+");
        } else {
            mensagemAlerta();
        }

    }

    public void onclicksubtracao(View v) {
        if (!primeironumero.isEmpty()) {
            operacao = "-";
            atualizarDisplay("-");
        } else {
            mensagemAlerta();
        }

    }

    public void onclickmultiplicacao(View v) {
        if (!primeironumero.isEmpty()) {
            operacao = "*";
            atualizarDisplay("x");
        } else {
            mensagemAlerta();
        }

    }

    public void onclickdivisao(View v) {
        if (!primeironumero.isEmpty()) {
            operacao = "/";
            atualizarDisplay("/");
        } else {
            mensagemAlerta();
        }

    }
//teste
    public void mensagemAlerta() {
        Toast.makeText(MainActivity.this, "Informe um número antes", Toast.LENGTH_LONG).show();
    }

    public void clear(View v) {
        display.setText("");
        primeironumero = "";
        segundonumero = "";
        operacao = "";
    }

    public void onclickigual(View v) {

        if (!primeironumero.isEmpty() && !segundonumero.isEmpty()) {

            float numero1 = Float.parseFloat(primeironumero);
            float numero2 = Float.parseFloat(segundonumero);
            float resultado = 0;
            boolean errodivisaoporzero = false;

            if ("+".equals(operacao)) {
                resultado = numero1 + numero2;
            } else if ("-".equals(operacao)) {
                resultado = numero1 - numero2;
            } else if ("*".equals(operacao)) {
                resultado = numero1 * numero2;
            } else if ("/".equals(operacao)) {
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    Toast.makeText(MainActivity.this, "Não é possível divisão por zero (0). Aperte C para iniciar uma outra operação", Toast.LENGTH_LONG).show();
                    errodivisaoporzero = true;
                }
            }
            if (!errodivisaoporzero) {
                display.setText(String.valueOf(resultado));
                Toast.makeText(MainActivity.this, "Aperte C para iniciar uma outra operação", Toast.LENGTH_LONG).show();
            }
        } else {
            mensagemAlerta();
        }
    }

    private void atualizarDisplay(String texto) {
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + texto;
        display.setText(textoDisplay);
    }

    private void atualizarnumerodigitado(String numero) {
        if (operacao.isEmpty()) {
            primeironumero = primeironumero + numero;
        } else {
            segundonumero = segundonumero + numero;
        }
    }
}