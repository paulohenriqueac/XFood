package br.com.phac.xfood.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.phac.xfood.R;
import br.com.phac.xfood.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null){
            LoginFragment loginFragment = LoginFragment.novaInstancia();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.login_content, loginFragment, "loginFragment")
                    .commit();
        }
    }
}
