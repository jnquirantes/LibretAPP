package com.app.programacion_multimedia.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.programacion_multimedia.FragHecho2;
import com.app.programacion_multimedia.MainActivity;
import com.app.programacion_multimedia.FragHecho;
import com.app.programacion_multimedia.FragEmpty;
import com.app.programacion_multimedia.tema4.Frag_t4_actividad2;

import com.app.programacion_multimedia.tema5.Frag_t5_actividad2;
import com.app.programacion_multimedia.tema5.Frag_t5_caso;
import com.app.programacion_multimedia.tema6.Frag_t6_actividad1;
import com.app.programacion_multimedia.tema6.Frag_t6_actividad2;
import com.app.programacion_multimedia.tema6.Frag_t6_casos;
import com.app.programacion_multimedia.tema7.Frag_t7_casos;
import com.app.programacion_multimedia.tema8.Frag_t8_caso;


public class ViewPageAdapter extends FragmentStateAdapter {

    private boolean tema4 = MainActivity.tema4;
    private boolean tema5 = MainActivity.tema5;
    private boolean tema6 = MainActivity.tema6;
    private boolean tema7 = MainActivity.tema7;
    private boolean tema8 = MainActivity.tema8;



    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(tema4) {
            switch (position) {
                case 0:
                    return new FragEmpty();
                case 1:
                    return new FragHecho();
                case 2:
                    return new Frag_t4_actividad2();
            }

        } else if (tema5){
                switch (position) {
                    case 0:
                        return new Frag_t5_caso();
                    case 1:
                        return new FragHecho();
                    case 2:
                        return new Frag_t5_actividad2();
                }

        } else if (tema6){
            switch (position) {
                case 0:
                    return new Frag_t6_casos();
                case 1:
                    return new Frag_t6_actividad1();
                case 2:
                    return new Frag_t6_actividad2();
            }
        } else if (tema7) {
            switch (position) {
                case 0:
                    return new Frag_t7_casos();
                case 1:
                    return new FragHecho();
                case 2:
                    return new FragHecho2();
            }
        } else if (tema8) {
            switch (position) {
                case 0:
                    return new Frag_t8_caso();
                case 1:
                    return new FragHecho();
                case 2:
                    return new FragHecho2();
            }
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}