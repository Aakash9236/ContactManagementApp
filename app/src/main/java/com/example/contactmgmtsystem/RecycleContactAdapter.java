package com.example.contactmgmtsystem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleContactAdapter extends RecyclerView.Adapter<RecycleContactAdapter.ViewHolder> {

    @NonNull
    Context context;
    public ArrayList<ContactList>arrContact;
    RecycleContactAdapter(Context context , ArrayList<com.example.contactmgmtsystem.ContactList>arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }
    public RecycleContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleContactAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imgContact.setImageResource(arrContact.get(position).image);
        holder.txtName.setText(arrContact.get(position).name);
        holder.txtNumber.setText(arrContact.get(position).number);
        holder.ListRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.update_conntact);

                EditText editName = dialog.findViewById(R.id.name);
                EditText editNumber = dialog.findViewById(R.id.number);
                Button btnUpdate = dialog.findViewById(R.id.btnSave);

                btnUpdate.setText("Update");

                TextView add = dialog.findViewById(R.id.Add);
                add.setText("Update");

                editName.setText((arrContact.get(position)).name);
                editNumber.setText((arrContact.get(position)).number);

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";
                        if(!editName.getText().toString().equals("")) {
                            name = editName.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!editNumber.getText().toString().equals("")) {
                            number = editNumber.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "Please Enter Contact Number", Toast.LENGTH_SHORT).show();
                        }
                        arrContact.set(position ,new ContactList(arrContact.get(position).image,name , number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        holder.ListRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Delete Contact")
                .setMessage("Are You sure want to Delete?")
                .setIcon(R.drawable.baseline_delete_24)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     arrContact.remove(position);
                     notifyItemRemoved(position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName , txtNumber;
        ImageView imgContact;
        LinearLayout ListRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            ListRow = itemView.findViewById(R.id.ListRow);

        }
    }
}
