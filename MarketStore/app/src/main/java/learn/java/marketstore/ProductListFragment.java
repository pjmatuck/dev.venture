package learn.java.marketstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {

    List<Produto> produtos = new ArrayList<>();
    List<Integer> idsProdutosComprados = new ArrayList<>();

    List<Produto> produtosComprados = new ArrayList<>();

    RecyclerView recyclerView;

    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_list, container, false);
        gerarProdutos();

        ListAdapter adapter = new ListAdapter(produtos, idsProdutosComprados);
        recyclerView = v.findViewById(R.id.recyclerViewListaProdutos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        setHasOptionsMenu(true);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuShoppingCart){
            selecionarProdutosCompradorPorId();
            NavDirections action = ProductListFragmentDirections.actionToShoppingCartFragment(
                    produtosComprados.toArray(new Produto[produtosComprados.size()]));
            Navigation.findNavController(getView()).navigate(action);
        }

        return super.onOptionsItemSelected(item);
    }

    private void gerarProdutos(){
        Produto produto;
        for (int i = 0; i < 10; i++){
            produto = new Produto(i, "produto"+i, "Descricao "+ i + " do Produto"+i,
                    "Longa descricao " + i + " do Produto"+ i, 2f);
            produtos.add(produto);
        }
    }

    private void selecionarProdutosCompradorPorId(){
        for (int id : idsProdutosComprados) {
            for(Produto produto : produtos){
                if(id == produto.getId()){
                    produtosComprados.add(produto);
                }
            }
        }
    }
}
