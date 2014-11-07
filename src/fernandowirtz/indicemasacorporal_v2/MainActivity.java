package fernandowirtz.indicemasacorporal_v2;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnFocusChangeListener{

private static final String LOGTAG="MainActivity";
	
	private IndiceMasaCorporal imc;
	EditText editPeso;
	EditText editAltura;
	TextView textViewResultado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editPeso = (EditText) findViewById(R.id.editPeso);
		editPeso.setOnFocusChangeListener(this);
		editAltura = (EditText) findViewById(R.id.editAltura);
		textViewResultado = (TextView) findViewById(R.id.textViewResultado);
		
	}
	
	/**
	 * onButtonClickCalcularIMC
	 */
	public void onButtonClickCalcularIMC(View v) {
		
		String peso;
		String altura;
		String resultado;
		String mensajeError = null;
		try {
			
			peso = editPeso.getText().toString();
			altura = editAltura.getText().toString();
			
			imc = new IndiceMasaCorporal(peso, altura);
			
			resultado = "Valor IMC = " + imc.valorIndiceMasaCorporal() + " - ";
			resultado = resultado.concat(imc.clasificacionOMS());
			textViewResultado.setText(resultado);
			Log.e(LOGTAG, imc.toString());
		} catch (IndiceMasaCorporalException e) {
			if (e.isErrorPeso()) {
				mensajeError="Peso introducido incorrectamente.";
			}
			if (e.isErrorAltura()){
				mensajeError="Altura introducida incorrectamente.";
			}
			if(e.isErrorAltura() && e.isErrorPeso()){
				mensajeError="Altura y peso introducidos incorrectamente.";
			}
			Toast.makeText(getApplicationContext(), mensajeError, 
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Log.e(LOGTAG, e.getMessage());
		}
	}
	
	public void onButtonAcercaDe(View v){
		Intent i =new Intent(this,Acerca_de.class);
		startActivity(i);
	}
	
	public void onClickEditTextAltura(View v){
		editAltura.setBackgroundColor(Color.WHITE);
		editAltura.setLinkTextColor(Color.BLUE);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		
		
	}
}