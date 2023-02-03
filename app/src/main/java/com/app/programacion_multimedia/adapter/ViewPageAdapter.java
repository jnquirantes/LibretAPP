package com.app.programacion_multimedia.adapter;

import static com.app.programacion_multimedia.MainActivity.tema4;
import static com.app.programacion_multimedia.MainActivity.tema5;
import static com.app.programacion_multimedia.MainActivity.tema6;
import static com.app.programacion_multimedia.MainActivity.tema7;
import static com.app.programacion_multimedia.MainActivity.tema8;
import static com.app.programacion_multimedia.MainActivity.tema9;
import static com.app.programacion_multimedia.MainActivity.tema10;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.app.programacion_multimedia.FragHecho2;
import com.app.programacion_multimedia.FragHecho;
import com.app.programacion_multimedia.FragEmpty;
import com.app.programacion_multimedia.tema10.Frag_t10_Actividad1;
import com.app.programacion_multimedia.tema10.Frag_t10_casos;
import com.app.programacion_multimedia.tema4.Frag_t4_actividad2;

import com.app.programacion_multimedia.tema5.Frag_t5_actividad2;
import com.app.programacion_multimedia.tema5.Frag_t5_caso;
import com.app.programacion_multimedia.tema6.Frag_t6_actividad1;
import com.app.programacion_multimedia.tema6.Frag_t6_actividad2;
import com.app.programacion_multimedia.tema6.Frag_t6_casos;
import com.app.programacion_multimedia.tema7.T7_Casos;
import com.app.programacion_multimedia.tema8.Frag_t8_caso;
import com.app.programacion_multimedia.tema9.Frag_t9_actividad1;


public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(FragmentActivity fragmentActivity) {
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
                    return new T7_Casos();
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
        } else if (tema9) {
            switch (position) {
                case 0:
                    return new FragHecho();
                case 1:
                    return new Frag_t9_actividad1();
                case 2:
                    return new FragHecho2();
            }
        } else if (tema10) {
            switch (position) {
                    case 0:
                        return new Frag_t10_casos();
                    case 1:
                        return new Frag_t10_Actividad1();
                    case 2:
                        return new FragEmpty();
            }
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}