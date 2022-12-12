package com.app.programacion_multimedia.tema6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import com.app.programacion_multimedia.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class T6_Caso5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6_caso5);

        Element versionElement = new Element();
        versionElement.setTitle("Version 6.2");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.ic_greenpeace)
                .addItem(versionElement)
                .addItem(getCopyRightsElement())
                .setDescription("Importamos librería de terceros para poder tener una forma sencilla" +
                        "de hacer una pagina Acerca de... Contiene todos los elementos necesarios")
                .addGroup("Conecta con nosotros")
                .addEmail("contacto.es@greenpeace.org")
                .addWebsite("https://es.greenpeace.org/es/")
                .addFacebook("greenpeace.spain")
                .addTwitter("greenpeace_esp")
                .addYoutube("UC8k1bQtLStynnqEfMB8c7dA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addGitHub("GreenAlbor")
                .addInstagram("greenpeace_esp")
                .create();

        setContentView(aboutPage);


    }

    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(("Copyrights"), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIconDrawable(R.drawable.ic_menu_camera);
        copyRightsElement.setAutoApplyIconTint(true);
        copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
        copyRightsElement.setIconNightTint(android.R.color.white);
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(v -> Toast.makeText(T6_Caso5.this, copyrights, Toast.LENGTH_SHORT).show());
        return copyRightsElement;
    }
}