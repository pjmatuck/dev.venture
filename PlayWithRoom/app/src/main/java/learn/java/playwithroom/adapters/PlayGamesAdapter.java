package learn.java.playwithroom.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import learn.java.playwithroom.R;
import learn.java.playwithroom.model.PlayGame;

public class PlayGamesAdapter extends RecyclerView.Adapter<PlayGamesAdapter.ViewHolder> {

    private List<PlayGame> playGames;

    public PlayGamesAdapter(List<PlayGame> playGames) {
        this.playGames = playGames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playgame_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(playGames.get(position).getId()));
        holder.name.setText(playGames.get(position).getName());
        holder.description.setText(playGames.get(position).getDescription());
        holder.player.setText(String.valueOf(playGames.get(position).getPlayers()));
    }

    @Override
    public int getItemCount() {
        return playGames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, name, description, player;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textViewId);
            name = itemView.findViewById(R.id.textViewName);
            description = itemView.findViewById(R.id.textViewDescription);
            player = itemView.findViewById(R.id.textViewPlayers);
        }
    }
}
