package fernandowirtz.indicemasacorporal_v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Acerca_de extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acerca_de);
	}
	
	public void onClickButtonOk(View view){
		this.finish();
	}
}
