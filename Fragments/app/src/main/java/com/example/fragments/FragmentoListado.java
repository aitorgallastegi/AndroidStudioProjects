package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
class FragmentListado extends Fragment {

    private Libro[] datos = new Libro [] {
            new Libro ("Persona 1", "Asunto del correo 1", "Texto del Correo 1",213),
            new Libro ("Persona 2", "Asunto del correo 2", "Texto del Correo 2",111),
            new Libro ("Persona 3", "Asunto del correo 3", "Texto del Correo 3",546)};
    private ListView list;
    private LibroListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView)getView().findViewById(R.id.list);
        list.setAdapter(new AdaptadorCorreos(this));
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onLibroSeleccionado(
                            (Libro)list.getAdapter().getItem(position));
            }
        });
    }
    class AdaptadorCorreos extends ArrayAdapter<Libro> {
        Activity context;
        AdaptadorCorreos(Fragment context) {
            super(context.getActivity(), R.layout.listitem_libro, datos);
            this.context = context.getActivity();
        }
        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_libro, null);

            TextView txtTitulo = (TextView) item.findViewById(R.id.txtTitulo);
            txtTitulo.setText(datos[position].getTitulo());

            TextView txtAutor = (TextView)item.findViewById(R.id.txtAutor);
            txtAutor.setText(datos[position].getAutor());
            return (item);
        }
    }


    public void setLibroListener (LibroListener listener){
        this.listener = listener;
    }
}
