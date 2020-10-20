package com.proyectoclase.fragments.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.proyectoclase.fragments.DescriptionActivity;
import com.proyectoclase.fragments.MainActivity;
import com.proyectoclase.fragments.R;

public class ComponentFragment extends Fragment {

    ListView listView;
    String[] androidOS = new String[]{"Vista (View)","Layout","Actividad (Activity)","Fragmentos (Fragment)","Servicio (Service)"};
    String[] version = new String[]{"Las vistas son los elementos que componen la interfaz de usuario de una aplicación: por ejemplo, un botón o una entrada de texto. Todas las vistas van a ser objetos descendientes de la clase View, y por tanto, pueden ser definidas utilizando código Java. Sin embargo, lo habitual será definir las vistas utilizando un fichero XML y dejar que el sistema cree los objetos por nosotros a partir de este fichero. Esta forma de trabajar es muy similar a la definición de una página web utilizando código HTML.",
            "Un layout es un conjunto de vistas agrupadas de una determinada forma. Vamos a disponer de diferentes tipos de layouts para organizar las vistas de forma lineal, en cuadrícula o indicando la posición absoluta de cada vista. Los layouts también son objetos descendientes de la clase View. Igual que las vistas, los layouts pueden ser definidos en código, aunque la forma habitual de definirlos es utilizando código XML.",
            "Una aplicación en Android va a estar formada por un conjunto de elementos básicos de visualización, coloquialmente conocidos como pantallas de la aplicación. En Android cada uno de estos elementos, o pantallas, se conoce como actividad. Su función principal es la creación de la interfaz de usuario."
            ,"La llegada de las tabletas trajo el problema de que las aplicaciones de Android ahora deben soportar pantallas más grandes. Si diseñamos una aplicación pensada para un dispositivo móvil y luego la ejecutamos en una tableta, el resultado no suele resultar satisfactorio.\n"
             ,"Un servicio es un proceso que se ejecuta “detrás”, sin la necesidad de una interacción con el usuario. Es algo parecido a un demonio en Unix o a un servicio en Windows. Se utilizan cuando queramos tener en ejecución un código de manera continua, aunque el usuario cambie de actividad. En Android disponemos de dos tipos de servicios: servicios locales, que son ejecutados en el mismo proceso, y servicios remotos, que son ejecutados en procesos separados.",
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.component_fragment_layout,container,false);
        listView = view.findViewById(R.id.lista);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,androidOS);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(getResources().getConfiguration().orientation == 1) {
                    Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                    intent.putExtra("DESCRIPCION",version[position]);
                    intent.putExtra("OS",androidOS[position]);
                   // descriptionFragment = DescriptionFragment.newInstance(version[position],androidOS[position]);
                    listView.setSelector(android.R.color.holo_blue_dark);
                    //     FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    //transaction.replace(R.id.contenedor,descriptionFragment);
                    startActivity(intent);
                }
                else{
                    DescriptionFragment descriptionFragment;
                    descriptionFragment = (DescriptionFragment) getFragmentManager().findFragmentById(R.id.fragment2);
                    descriptionFragment.change(version[position],androidOS[position]);
                    listView.setSelector(android.R.color.holo_blue_dark);


                   /* TextFragment textFragment = TextFragment.newInstance(version[position],androidOS[position]);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contenedor,textFragment).commit();*/
                }
            }
        });
        return view;
    }

    public static ComponentFragment newInstance(String[] array){
        ComponentFragment fragmentList = new ComponentFragment();
        Bundle bundle = new Bundle();

        bundle.putStringArray("OS",array);
        fragmentList.setArguments(bundle);
        return fragmentList;
    }
}
