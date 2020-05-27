package learn.java.marketstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    List<Produto> listaProdutos;
    List<Integer> listaIdsProdutosComprados;

    public ListAdapter(List<Produto> produtos, List<Integer> listaIdsProdutos){
        this.listaProdutos = produtos;
        this.listaIdsProdutosComprados = listaIdsProdutos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nomeProduto.setText(listaProdutos.get(position).getNomeProduto());
        holder.breveDescricaoProduto.setText(listaProdutos.get(position).getBreveDescricao());

        holder.produtoEscolhido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    listaIdsProdutosComprados.add(listaProdutos.get(position).getId());
                } else {
                    listaIdsProdutosComprados.remove(listaProdutos.get(position).getId());
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = ProductListFragmentDirections.actionToProductDetailFragment(listaProdutos.get(position));
                Navigation.findNavController(v).navigate(action);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nomeProduto;
        TextView breveDescricaoProduto;
        CheckBox produtoEscolhido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.textViewNomeProduto);
            breveDescricaoProduto = itemView.findViewById(R.id.textViewBreveDescricao);
            produtoEscolhido = itemView.findViewById(R.id.checkBoxComprado);
        }
    }
}
