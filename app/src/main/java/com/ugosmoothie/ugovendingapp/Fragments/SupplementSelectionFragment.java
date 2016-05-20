package com.ugosmoothie.ugovendingapp.Fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.orm.SugarRecord;
import com.ugosmoothie.ugovendingapp.Data.*;
import com.ugosmoothie.ugovendingapp.PurchaseSmoothie;
import com.ugosmoothie.ugovendingapp.R;

import java.util.Locale;


/**
 * Created by Michelle on 3/14/2016.
 */
public class SupplementSelectionFragment extends Fragment {

    private int no_supplement = 1;
    private int smashed_almonds = 2;
    private int pumpkin_seed_powder = 3;
    private int ground_flax_seed = 4;
    private int hemp_protein = 5;
    private Boolean lang_french = true;

    Locale myLocale;

    public int getNo_supplement(){
        return no_supplement;
    }

    public int getSmashed_almonds(){
        return smashed_almonds;
    }
    public int getPumpkin_seed_powder(){
        return pumpkin_seed_powder;
    }
    public int getGround_flax_seed(){
        return ground_flax_seed;
    }
    public int getHemp_protein(){
        return hemp_protein;
    }

    public Boolean getLang_french(){
        return lang_french;
    }
    public void setLang_french(Boolean lang_french) {
        this.lang_french = lang_french;
    }

    //Set Language in Locale
    private void setLocal(String language)
    {
        myLocale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

/*        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
        getActivity().getBaseContext().getResources().getDisplayMetrics());*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.supplement_selection_view, container, false);
        final Button lang =  (Button) rootView.findViewById(R.id.lingual_tag);
        RelativeLayout supplement_n = (RelativeLayout) rootView.findViewById(R.id.nextTime_tag);
        RelativeLayout supplement_a = (RelativeLayout) rootView.findViewById(R.id.alm_tag);
        RelativeLayout supplement_p = (RelativeLayout) rootView.findViewById(R.id.pmkn_tag);
        RelativeLayout supplement_f = (RelativeLayout) rootView.findViewById(R.id.flx_tag);
        RelativeLayout supplement_h = (RelativeLayout) rootView.findViewById(R.id.hp_tag);

        //Language Change
        setLocal("fr");
        setLang_french(true);
        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getLang_french()) {
                    setLocal("en");
                    setLang_french(false);
                } else {
                    setLocal("fr");
                    setLang_french(true);
                }

                //inflater.inflate(android.R.layout.supplement_selection_view, container, false);
            }
        });

        //Choosing Smoothie
        supplement_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getNo_supplement());
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });
        supplement_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getSmashed_almonds());
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });
        supplement_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getPumpkin_seed_powder());
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });
        supplement_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getGround_flax_seed());
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });
        supplement_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentSelection.getInstance().setCurrentSmoothie(getHemp_protein());
                ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(3);
            }
        });
        return rootView;
    }

    /*private void checkDefaults() {
        if (Supplement.listAll(Supplement.class).size() == 0) {
            Supplement groundFlaxSeed = new Supplement("Ground Flax Seed", 1.00f);
            groundFlaxSeed.save();

            Supplement pumpkinSeedProtein = new Supplement("Pumpkin Seed Protein", 1.00f);
            pumpkinSeedProtein.save();

            Supplement hempProtein = new Supplement("Hemp Protein", 1.00f);
            hempProtein.save();

            Supplement groundAlmonds = new Supplement("Ground Almonds", 1.00f);
            groundAlmonds.save();

            Supplement none = new Supplement("None", 5.00f);
            none.save();
        }
    }*/

}
