package learn.java.marketstore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import learn.java.marketstore.databinding.FragmentProductDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends Fragment {

    FragmentProductDetailBinding binding;

    public ProductDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProductDetailBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        if(getArguments() != null){
            Produto produto = ProductDetailFragmentArgs.fromBundle(getArguments()).getProduto();

            binding.textViewNomeProduto.setText(produto.getNomeProduto());
            binding.textViewPreco.setText(String.valueOf(produto.getPreco()));
            binding.textViewLongaDescricao.setText(produto.getLongaDescricao());
        }

        return v;
    }
}
