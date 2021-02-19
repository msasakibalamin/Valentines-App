package com.example.valentine;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ShayarAdapter extends RecyclerView.Adapter<ShayarAdapter.ShayariViewHolder> {

    private Context context;
    private ArrayList<ShayarData> list;

    public ShayarAdapter(Context context, ArrayList<ShayarData> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ShayariViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ShayariViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShayariViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getText());
        setAnimation(holder.itemView);

        holder.whatsapp.setOnClickListener(v ->{

            try {
                Intent whatsappShare = new Intent(Intent.ACTION_SEND);
                whatsappShare.setType("text/plane");
                whatsappShare.setPackage("com.whatsapp");
                whatsappShare.putExtra(Intent.EXTRA_TEXT, list.get(position).getText());
                context.startActivity(whatsappShare);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        holder.share.setOnClickListener(v ->{
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plane");
            share.putExtra(Intent.EXTRA_TEXT, list.get(position).getText());
            context.startActivity(share);
        });

        holder.copy.setOnClickListener(v ->{
            ClipboardManager  clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData data = (ClipData) ClipData.newPlainText("text", list.get(position).getText());
            clipboardManager.setPrimaryClip(data);

            Toast.makeText(context, "Text Copied", Toast.LENGTH_SHORT).show();
        });
    }

    private void setAnimation(View view){
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        view.setAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShayariViewHolder extends RecyclerView.ViewHolder {

        private ImageView whatsapp, share, copy;
        private TextView textView;

        public ShayariViewHolder(@NonNull View itemView) {
            super(itemView);

            whatsapp = itemView.findViewById(R.id.whatsapp);
            share = itemView.findViewById(R.id.share);
            copy = itemView.findViewById(R.id.copy);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
