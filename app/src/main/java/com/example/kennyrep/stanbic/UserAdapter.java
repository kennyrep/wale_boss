package com.example.kennyrep.stanbic;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kennyrep.stanbic.database.MyAppDatabase;
import com.example.kennyrep.stanbic.database.User;

import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Activity activity;
    List<User> users;

    public UserAdapter(Activity activity, List<User> users) {
        this.activity = activity;
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
    }

    public void setData(List<User> userList) {
        this.users = userList;
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView email;
        public CardView parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            parentLayout = itemView.findViewById(R.id.usercard);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, Information.class);
                    User user = users.get(getAdapterPosition());
                    intent.putExtra("ID", user.getId());
                    activity.startActivity(intent);

                }
            });

        }


    }
}

